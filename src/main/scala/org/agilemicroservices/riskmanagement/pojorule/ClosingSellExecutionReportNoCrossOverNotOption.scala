package org.agilemicroservices.riskmanagement.pojorule

import org.drools.model.DSL._
import org.drools.model.Drools

import org.agilemicroservices.drools.DroolsUtility._
import org.agilemicroservices.drools.DroolsRule
import org.agilemicroservices.entity.{Account, Execution, Position}

@DroolsRule
class ClosingSellExecutionReportNoCrossOverNotOption {

  //val account = fact[Account]
  val account = any(classOf[Account])
  val execution = any(classOf[Execution])

  val left = when(
    input(account),
    input(execution),
    expr(execution,
      (execution : Execution)  =>
        execution.isSellExecution && !execution.isOptionExecution),

    expr(execution, account,
      (execution : Execution, account : Account) =>
        execution.accountNumber == account.accountNumber)
  )

  def then(drools: Drools, account: Account, execution: Execution)
  {
    val executionValue = execution.lastPx * execution.lastQty

    account.cashBalance += executionValue
    account.totalCash += executionValue
    println ("Rule finished")
  }
}
