package org.agilemicroservices.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;


@XmlRootElement
@Entity(name = "account")
public class Account {

    @Id
    public Long accountNumber;

    public String accountType;
    public String accountName;
    public Long subNo;

    public BigDecimal moneyMarket;      //not changed by trading during the day

    public BigDecimal startingCashBalance;
    public BigDecimal startingTotalCash;
    public BigDecimal startingTotalMarketValue;
    public BigDecimal startingLongMarketValue;
    public BigDecimal startingShortMarketValue;
    public BigDecimal startingOtherMarketValue;
    public BigDecimal startingEquity;
    public BigDecimal startingEquityPercent;

    public BigDecimal cashBalance;
    public BigDecimal totalCash;
    public BigDecimal totalMarketValue;
    public BigDecimal longMarketValue;
    public BigDecimal shortMarketValue;
    public BigDecimal equity;
    public BigDecimal equityPercent;

    public BigDecimal tailRisk;
    public BigDecimal tailRiskEquityPercent;
    public BigDecimal ruinDays;
    public BigDecimal riskEquity;
    public BigDecimal riskEquityPercent;

    public Integer activityCount;


    public Account() {
        moneyMarket = BigDecimal.ZERO;

        cashBalance = BigDecimal.ZERO;
        totalCash = BigDecimal.ZERO;
        totalMarketValue = BigDecimal.ZERO;
        longMarketValue = BigDecimal.ZERO;
        shortMarketValue = BigDecimal.ZERO;
        equity = BigDecimal.ZERO;
        equityPercent = BigDecimal.ZERO;

        startingCashBalance = BigDecimal.ZERO;
        startingTotalCash = BigDecimal.ZERO;
        startingTotalMarketValue = BigDecimal.ZERO;
        startingLongMarketValue = BigDecimal.ZERO;
        startingShortMarketValue = BigDecimal.ZERO;
        startingOtherMarketValue = BigDecimal.ZERO;
        startingEquity = BigDecimal.ZERO;
        startingEquityPercent = BigDecimal.ZERO;

        activityCount = 0;
    }


    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getSubNo() {
        return subNo;
    }

    public void setSubNo(Long subNo) {
        this.subNo = subNo;
    }

    public BigDecimal getMoneyMarket() {
        return moneyMarket;
    }

    public void setMoneyMarket(BigDecimal moneyMarket) {
        this.moneyMarket = moneyMarket;
    }

    public BigDecimal getStartingCashBalance() {
        return startingCashBalance;
    }

    public void setStartingCashBalance(BigDecimal startingCashBalance) {
        this.startingCashBalance = startingCashBalance;
    }

    public BigDecimal getStartingTotalCash() {
        return startingTotalCash;
    }

    public void setStartingTotalCash(BigDecimal startingTotalCash) {
        this.startingTotalCash = startingTotalCash;
    }

    public BigDecimal getStartingTotalMarketValue() {
        return startingTotalMarketValue;
    }

    public void setStartingTotalMarketValue(BigDecimal startingTotalMarketValue) {
        this.startingTotalMarketValue = startingTotalMarketValue;
    }

    public BigDecimal getStartingLongMarketValue() {
        return startingLongMarketValue;
    }

    public void setStartingLongMarketValue(BigDecimal startingLongMarketValue) {
        this.startingLongMarketValue = startingLongMarketValue;
    }

    public BigDecimal getStartingShortMarketValue() {
        return startingShortMarketValue;
    }

    public void setStartingShortMarketValue(BigDecimal startingShortMarketValue) {
        this.startingShortMarketValue = startingShortMarketValue;
    }

    public BigDecimal getStartingOtherMarketValue() {
        return startingOtherMarketValue;
    }

    public void setStartingOtherMarketValue(BigDecimal startingOtherMarketValue) {
        this.startingOtherMarketValue = startingOtherMarketValue;
    }

    public BigDecimal getStartingEquity() {
        return startingEquity;
    }

    public void setStartingEquity(BigDecimal startingEquity) {
        this.startingEquity = startingEquity;
    }

    public BigDecimal getStartingEquityPercent() {
        return startingEquityPercent;
    }

    public void setStartingEquityPercent(BigDecimal startingEquityPercent) {
        this.startingEquityPercent = startingEquityPercent;
    }

    public BigDecimal getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(BigDecimal cashBalance) {
        this.cashBalance = cashBalance;
    }

    public BigDecimal getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(BigDecimal totalCash) {
        this.totalCash = totalCash;
    }

    public BigDecimal getTotalMarketValue() {
        return totalMarketValue;
    }

    public void setTotalMarketValue(BigDecimal totalMarketValue) {
        this.totalMarketValue = totalMarketValue;
    }

    public BigDecimal getLongMarketValue() {
        return longMarketValue;
    }

    public void setLongMarketValue(BigDecimal longMarketValue) {
        this.longMarketValue = longMarketValue;
    }

    public BigDecimal getShortMarketValue() {
        return shortMarketValue;
    }

    public void setShortMarketValue(BigDecimal shortMarketValue) {
        this.shortMarketValue = shortMarketValue;
    }

    public BigDecimal getEquity() {
        return equity;
    }

    public void setEquity(BigDecimal equity) {
        this.equity = equity;
    }

    public BigDecimal getEquityPercent() {
        return equityPercent;
    }

    public void setEquityPercent(BigDecimal equityPercent) {
        this.equityPercent = equityPercent;
    }

    public Integer getActivityCount() {
        return activityCount;
    }

    public void setActivityCount(Integer activityCount) {
        this.activityCount = activityCount;
    }

    public BigDecimal getTailRisk() {
        return tailRisk;
    }

    public void setTailRisk(BigDecimal tailRisk) {
        this.tailRisk = tailRisk;
    }

    public BigDecimal getTailRiskEquityPercent() {
        return tailRiskEquityPercent;
    }

    public void setTailRiskEquityPercent(BigDecimal tailRiskEquityPercent) {
        this.tailRiskEquityPercent = tailRiskEquityPercent;
    }

    public BigDecimal getRuinDays() {
        return ruinDays;
    }

    public void setRuinDays(BigDecimal ruinDays) {
        this.ruinDays = ruinDays;
    }

    public BigDecimal getRiskEquity() {
        return riskEquity;
    }

    public void setRiskEquity(BigDecimal riskEquity) {
        this.riskEquity = riskEquity;
    }

    public BigDecimal getRiskEquityPercent() {
        return riskEquityPercent;
    }

    public void setRiskEquityPercent(BigDecimal riskEquityPercent) {
        this.riskEquityPercent = riskEquityPercent;
    }

    @Override
    public String toString() {
        return "Account{" +
                ", accountNumber=" + accountNumber +
                ", accountType='" + accountType + '\'' +
                ", accountName='" + accountName + '\'' +
                ", subNo=" + subNo +
                ", moneyMarket=" + moneyMarket +
                ", startingCashBalance=" + startingCashBalance +
                ", startingTotalCash=" + startingTotalCash +
                ", startingTotalMarketValue=" + startingTotalMarketValue +
                ", startingLongMarketValue=" + startingLongMarketValue +
                ", startingShortMarketValue=" + startingShortMarketValue +
                ", startingOtherMarketValue=" + startingOtherMarketValue +
                ", startingEquity=" + startingEquity +
                ", startingEquityPercent=" + startingEquityPercent +
                ", cashBalance=" + cashBalance +
                ", totalCash=" + totalCash +
                ", totalMarketValue=" + totalMarketValue +
                ", longMarketValue=" + longMarketValue +
                ", shortMarketValue=" + shortMarketValue +
                ", equity=" + equity +
                ", equityPercent=" + equityPercent +
                ", tailRisk=" + tailRisk +
                ", tailRiskEquityPercent=" + tailRiskEquityPercent +
                ", ruinDays=" + ruinDays +
                ", riskEquity=" + riskEquity +
                ", riskEquityPercent=" + riskEquityPercent +
                ", activityCount=" + activityCount +
                '}';
    }
}
