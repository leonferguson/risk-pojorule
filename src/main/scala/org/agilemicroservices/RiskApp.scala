package org.agilemicroservices

import org.agilemicroservices.drools.DroolsUtility._
import org.agilemicroservices.entity.{Account, Execution, Position}
import org.agilemicroservices.riskmanagement.pojorule.ClosingSellExecutionReportNoCrossOverNotOption
import org.drools.retebuilder.CanonicalKieBase
import org.kie.api.runtime.KieSession

object RiskApp extends App {

  val obj = new ClosingSellExecutionReportNoCrossOverNotOption()
  val obj2 = classOf[ClosingSellExecutionReportNoCrossOverNotOption].newInstance()

  val kieBase: CanonicalKieBase = new CanonicalKieBase
  val rules = getRulesFromPackage("org.agilemicroservices.riskmanagement")

  kieBase.addRules(rules:_*)
  val ksession: KieSession = kieBase.newKieSession

  val account = new Account()
  account.accountName = "Test Account"
  account.accountNumber = 1234L

  val position = new Position()
  position.symbol = "IBM"
  position.accountNumber = 1234L
  position.securityId = 100L
  position.quantity = new java.math.BigDecimal("1000.0")


  val execution = new Execution()
  execution.accountNumber = 1234L
  execution.securityId = 100L
  execution.execType = "2"
  execution.lastQty = new java.math.BigDecimal("100.0")

  ksession.insert(account)
  ksession.insert(position)
  ksession.insert(execution)

  ksession.fireAllRules()
}
