package org.agilemicroservices.riskmanagement.pojorule;

import org.agilemicroservices.entity.*;
import org.drools.retebuilder.CanonicalKieBase;
import org.kie.api.runtime.KieSession;

import static org.drools.pojorule.PojoRuleAnalyzer.toModule;

public class RiskManagementTest {

    public static void main(String[] args) {
        CanonicalKieBase kieBase = new CanonicalKieBase();
        kieBase.addRules(toModule(RiskModule.class));
        KieSession ksession = kieBase.newKieSession();

        Account account = new Account();
        account.accountName = "Test Account";
        account.accountNumber = 1234L;

        Position position = new Position();
        position.symbol = "IBM";
        position.accountNumber = 1234L;
        position.securityId = 100L;
        position.quantity = new java.math.BigDecimal("1000.0");

        Execution execution = new Execution();
        execution.symbol = "IBM";
        execution.accountNumber = 1234L;
        execution.securityId = 100L;
        execution.side = "2";
        execution.lastQty = new java.math.BigDecimal("100.0");

        ksession.insert(account);
        ksession.insert(position);
        ksession.insert(execution);

        ksession.fireAllRules();

    }
}
