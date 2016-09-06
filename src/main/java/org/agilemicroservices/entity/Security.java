package org.agilemicroservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;


@Entity(name = "security_master")
public class Security {

    @Id
    @Column(nullable = false)
    public Long securityId;

    public String securityIdType;
    public String sector;
    public String symbol;
    public String cusip;
    public String isin;

    public String securityType;
    public BigDecimal closingPrice;
    public String closingPriceDate;
    public BigDecimal lastPrice;
    public String lastPriceDateTime;

    public Long underlyingSecurityId;
    public String underlyingSymbol;
    public BigDecimal contractSize;
    public Long bondFactor;
    public BigDecimal strikeprice;
    public String putOrCall;
    //expiration????


    public Long getSecurityId() {
        return securityId;
    }

    public void setSecurityId(Long securityId) {
        this.securityId = securityId;
    }

    public String getSecurityIdType() {
        return securityIdType;
    }

    public void setSecurityIdType(String securityIdType) {
        this.securityIdType = securityIdType;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
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

    public Long getUnderlyingSecurityId() {
        return underlyingSecurityId;
    }

    public void setUnderlyingSecurityId(Long underlyingSecurityId) {
        this.underlyingSecurityId = underlyingSecurityId;
    }

    public String getUnderlyingSymbol() {
        return underlyingSymbol;
    }

    public void setUnderlyingSymbol(String underlyingSymbol) {
        this.underlyingSymbol = underlyingSymbol;
    }

    public BigDecimal getContractSize() {
        return contractSize;
    }

    public void setContractSize(BigDecimal contractSize) {
        this.contractSize = contractSize;
    }

    public Long getBondFactor() {
        return bondFactor;
    }

    public void setBondFactor(Long bondFactor) {
        this.bondFactor = bondFactor;
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
}
