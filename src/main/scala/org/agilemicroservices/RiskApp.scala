package org.agilemicroservices

import org.agilemicroservices.drools.DroolsUtility._
import org.agilemicroservices.entity.{Account, Execution, Position}
import org.agilemicroservices.riskmanagement.pojorule.ClosingSellExecutionReportNoCrossOverNotOption
import org.drools.model.Rule
import org.drools.pojorule.PojoRuleAnalyzer
import org.drools.retebuilder.CanonicalKieBase
import org.kie.api.runtime.KieSession
import org.drools.pojorule.PojoRuleAnalyzer.toRule

object RiskApp extends App {

  val kieBase: CanonicalKieBase = new CanonicalKieBase
  //val rules = getRulesFromPackage("org.agilemicroservices.riskmanagement")

  val rules = new Array[Rule](1)
  rules(0) = PojoRuleAnalyzer.toRule(classOf[ClosingSellExecutionReportNoCrossOverNotOption])

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
  execution.symbol = "IBM";
  execution.accountNumber = 1234L
  execution.securityId = 100L
  execution.side = "2"
  execution.lastQty = new java.math.BigDecimal("100.0")
  execution.lastPx = new java.math.BigDecimal("100.0")

  ksession.insert(account)
  ksession.insert(position)
  ksession.insert(execution)

  ksession.fireAllRules()
}
