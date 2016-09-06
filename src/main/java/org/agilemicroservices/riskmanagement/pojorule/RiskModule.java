package org.agilemicroservices.riskmanagement.pojorule;

import java.math.BigDecimal;

import org.drools.model.Drools;
import org.drools.model.Variable;
import static org.drools.model.DSL.*;

import org.agilemicroservices.entity.*;

public class RiskModule {
    public static class ClosingSellExecutionReportNoCrossOverNotOptionJava {

        Variable<Account> account = any(Account.class);
        Variable<Position> position = any(Position.class);
        Variable<Execution> execution = any(Execution.class);

        Object when = when(
                input(account),
                input(position),
                input(execution),
                //and(
                        expr(execution,
                                (execution ->
                                        execution.isSellExecution() && !execution.isOptionExecution())),

                        expr(execution, account,
                                (execution, account) ->
                                        execution.accountNumber == account.accountNumber),

                        expr(execution, position,
                                (execution, position) ->
                                        execution.accountNumber == position.accountNumber &&
                                        execution.securityId == position.securityId &&
                                        position.quantity.compareTo(BigDecimal.ZERO) > 0 &&
                                        position.quantity.compareTo(execution.lastQty) > 0 )
                //)
        );

        //does not support more than 2 parameters after drools
        public void then(Drools drools, Account account, Position position) {//, Execution execution) {
//        BigDecimal executionValue = execution.lastPx.multiply(execution.lastQty);
//        BigDecimal executionValue = BigDecimal.ZERO;
//        account.cashBalance = account.cashBalance.add(executionValue);
//        account.totalCash = account.totalCash.add(executionValue);
//        position.quantity = position.quantity.subtract(execution.lastQty.abs());
            System.out.println("Rule finished");
        }
    }
}