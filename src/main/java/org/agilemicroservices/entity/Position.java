package org.agilemicroservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity(name = "position")
@IdClass(Position.PositionId.class)
public class Position {

    @Id
    @Column(nullable = false)
    public Long accountNumber;

    @Id
    @Column(nullable = false)
    public Long securityId;

    public String securityType;
    public String securityIdType;
    public String symbol;
    public BigDecimal quantity;
    public BigDecimal marketValue;
    public BigDecimal closingPrice;
    public String closingPriceDate;
    public BigDecimal closingMarketValue;
    public BigDecimal lastPrice;
    public String lastPriceDateTime;

    public BigDecimal strikeprice;
    public String putOrCall;
    public String underlyingSymbol;
    public Long underlyingSecurityId;
    public Integer activityCount;

    public Position() {
        quantity = BigDecimal.ZERO;
        marketValue = BigDecimal.ZERO;
        closingPrice = BigDecimal.ZERO;
        closingMarketValue = BigDecimal.ZERO;
        lastPrice = BigDecimal.ZERO;
        strikeprice = BigDecimal.ZERO;
        activityCount = 0;
    }


    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getSecurityId() {
        return securityId;
    }

    public void setSecurityId(Long securityId) {
        this.securityId = securityId;
    }

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }

    public String getSecurityIdType() {
        return securityIdType;
    }

    public void setSecurityIdType(String securityIdType) {
        this.securityIdType = securityIdType;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

//    public BigDecimal getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(BigDecimal quantity) {
//        this.quantity = quantity;
//    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    public BigDecimal getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(BigDecimal closingPrice) {
        this.closingPrice = closingPrice;
    }

    public String getClosingPriceDate() {
        return closingPriceDate;
    }

    public void setClosingPriceDate(String closingPriceDate) {
        this.closingPriceDate = closingPriceDate;
    }

    public BigDecimal getClosingMarketValue() {
        return closingMarketValue;
    }

    public void setClosingMarketValue(BigDecimal closingMarketValue) {
        this.closingMarketValue = closingMarketValue;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getLastPriceDateTime() {
        return lastPriceDateTime;
    }

    public void setLastPriceDateTime(String lastPriceDateTime) {
        this.lastPriceDateTime = lastPriceDateTime;
    }

    public BigDecimal getStrikeprice() {
        return strikeprice;
    }

    public void setStrikeprice(BigDecimal strikeprice) {
        this.strikeprice = strikeprice;
    }

    public String getPutOrCall() {
        return putOrCall;
    }

    public void setPutOrCall(String putOrCall) {
        this.putOrCall = putOrCall;
    }

    public String getUnderlyingSymbol() {
        return underlyingSymbol;
    }

    public void setUnderlyingSymbol(String underlyingSymbol) {
        this.underlyingSymbol = underlyingSymbol;
    }

    public Long getUnderlyingSecurityId() {
        return underlyingSecurityId;
    }

    public void setUnderlyingSecurityId(Long underlyingSecurityId) {
        this.underlyingSecurityId = underlyingSecurityId;
    }

    public Integer getActivityCount() {
        return activityCount;
    }

    public void setActivityCount(Integer activityCount) {
        this.activityCount = activityCount;
    }

    @Override
    public String toString() {
        return "Position{" +
                "accountNumber=" + accountNumber +
                ", securityId=" + securityId +
                ", symbol='" + symbol + '\'' +
                '}';
    }


    public static class PositionId implements Serializable {
        public Long accountNumber;
        public Long securityId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PositionId that = (PositionId) o;

            if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
                return false;
            return securityId != null ? securityId.equals(that.securityId) : that.securityId == null;

        }

        @Override
        public int hashCode() {
            int result = accountNumber != null ? accountNumber.hashCode() : 0;
            result = 31 * result + (securityId != null ? securityId.hashCode() : 0);
            return result;
        }
    }
}
