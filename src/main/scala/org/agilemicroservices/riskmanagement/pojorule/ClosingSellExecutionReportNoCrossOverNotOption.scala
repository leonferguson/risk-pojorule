package org.agilemicroservices.riskmanagement.pojorule

import org.drools.model.DSL._
import org.drools.model.Drools
import org.agilemicroservices.drools.DroolsRule
import org.agilemicroservices.entity.{Account, Execution, Position}

@DroolsRule
class ClosingSellExecutionReportNoCrossOverNotOption {

  implicit def javaBigDecimal2bigDecimal(x: java.math.BigDecimal): BigDecimal = BigDecimal(x)
  implicit def bigDecimal2JavaBigDecimal(x: BigDecimal): java.math.BigDecimal = x.bigDecimal

  var account = any(classOf[Account])
  var position = any(classOf[Position])
  var execution = any(classOf[Execution])

  val left = when(
    input(account),
    input(position),
    input(execution),
    and(
      //only two parameters to lambda
      expr(execution,
        (execution: Execution)  =>
          execution.isSellExecution && !execution.isOptionExecution),

      //implicits do not work
      expr(execution, account,
        (execution : Execution, account : Account) =>
          execution.accountNumber == account.accountNumber),

      //fails on serializeable
      expr(execution, position,
        (execution : Execution, position: Position) =>
          execution.accountNumber == position.accountNumber &&
            execution.securityId == position.securityId &&
            position.quantity > 0.00 &&
            position.quantity > execution.lastQty)
    )
  )

  //does not like more than 2 parameters
  def then(drools: Drools, account: Account, position : Position, execution: Execution)
  {
    val executionValue = execution.lastPx * execution.lastQty

    account.cashBalance += executionValue
    account.totalCash += executionValue
    position.quantity -= execution.lastQty.abs
  }
}