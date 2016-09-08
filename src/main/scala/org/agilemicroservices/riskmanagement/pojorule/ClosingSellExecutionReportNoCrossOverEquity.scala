package org.agilemicroservices.riskmanagement.pojorule

import org.agilemicroservices.drools.DroolsRule
import org.drools.model.DSL._
import org.drools.model.{Drools, Variable}
import org.agilemicroservices.drools.DroolsUtility._

import org.agilemicroservices.entity.{Account, Execution, Position}

@DroolsRule
class ClosingSellExecutionReportNoCrossOverEquity {

  val account = any(classOf[Account])
  val position = any(classOf[Position])
  val execution = any(classOf[Execution])

  val left = when(
    input(account),
    input(position),
    input(execution),
    expr(execution,
      (execution : Execution)  =>
        execution.isSellExecution && !execution.isOptionExecution),

    //    implicits do not work
    //    only two expressions
    expr(execution, account,
      (execution : Execution, account : Account) =>
        execution.accountNumber == account.accountNumber),

    //fails on serializeable
    //only two parameters to lambda
    expr(execution, position,
      (execution : Execution, position: Position) =>
        execution.accountNumber == position.accountNumber &&
          execution.securityId == position.securityId &&
          position.quantity > 0.00 &&
          position.quantity > execution.lastQty)
  )

  //does not support more than 2 parameters after drools
  def then(drools: Drools, account: Account, position : Position, execution: Execution)
  {
    val executionValue = execution.lastPx * execution.lastQty

    account.cashBalance += executionValue
    account.totalCash += executionValue
    position.quantity -= execution.lastQty.abs
    println ("Rule finished")
  }
}
