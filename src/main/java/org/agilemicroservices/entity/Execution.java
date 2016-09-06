package org.agilemicroservices.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "execution")
public class Execution {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "execution_id")
    @TableGenerator(name = "execution_id", allocationSize = 1000)
    @Column(nullable = false)
    public Long id;

    public Long accountNumber;
    public String execType;
    public String account;
    public String clOrdID;
    public String orderID;
    public String execId;
    public String fixSecurityId;
    public Long securityId;
    public String securityIdType;
    public String symbol;
    public String transactTime;
    public String openClose;
    public String side;
    public BigDecimal lastQty;
    public BigDecimal orderQty;
    public BigDecimal leavesQty;
    public BigDecimal lastPx;

    public String platform;

    @XmlTransient
    @Column(length = 1024)
    public String fixMessage;
    public String originalSymbol;
    public String errorMessage;


    public Execution() {
        accountNumber = 0L;
    }


    public boolean isOptionExecution() {
        return (symbol.length() == 21);
    }

    public boolean isBuyExecution() {
        return (("1".equals(side)) ||
                ("3".equals(side)));
    }

    public boolean isSellExecution() {
        return (("2".equals(side)) ||
                ("4".equals(side)) ||
                ("5".equals(side)) ||
                ("6".equals(side)));
    }

    public boolean isFill() {
        return ("1".equals(execType) ||
                "2".equals(execType));
    }


    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExecType() {
        return execType;
    }

    public void setExecType(String execType) {
        this.execType = execType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getClOrdID() {
        return clOrdID;
    }

    public void setClOrdID(String clOrdID) {
        this.clOrdID = clOrdID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getExecId() {
        return execId;
    }

    public void setExecId(String execId) {
        this.execId = execId;
    }

    public String getFixSecurityId() {
        return fixSecurityId;
    }

    public void setFixSecurityId(String fixSecurityId) {
        this.fixSecurityId = fixSecurityId;
    }

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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTransactTime() {
        return transactTime;
    }

    public void setTransactTime(String transactTime) {
        this.transactTime = transactTime;
    }

    public String getOpenClose() {
        return openClose;
    }

    public void setOpenClose(String openClose) {
        this.openClose = openClose;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public BigDecimal getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(BigDecimal orderQty) {
        this.orderQty = orderQty;
    }

    public BigDecimal getLeavesQty() {
        return leavesQty;
    }

    public void setLeavesQty(BigDecimal leavesQty) {
        this.leavesQty = leavesQty;
    }

    public BigDecimal getLastPx() {
        return lastPx;
    }

    public void setLastPx(BigDecimal lastPx) {
        this.lastPx = lastPx;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getFixMessage() {
        return fixMessage;
    }

    public void setFixMessage(String fixMessage) {
        this.fixMessage = fixMessage;
    }

    public String getOriginalSymbol() {
        return originalSymbol;
    }

    public void setOriginalSymbol(String originalSymbol) {
        this.originalSymbol = originalSymbol;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


//    @XmlTransient
//    public quickfix.Message parseFixMessage() {
//
//        DataDictionary dictionary = getDataDictionary();
//
//        quickfix.Message message = new quickfix.Message();
//
//        try {
//            message.fromString(fixMessage, dictionary, false);
//        } catch (InvalidMessage e) {
//            throw new IllegalStateException(e);
//        }
//
//        return message;
//    }

//    @XmlTransient
//    public String toXml() {
//        quickfix.Message message = parseFixMessage();
//        return message.toXML(getDataDictionary());
//    }

//    @XmlTransient
//    private DataDictionary getDataDictionary() {
//        DefaultDataDictionaryProvider provider = new DefaultDataDictionaryProvider(true);
//        return provider.getApplicationDataDictionary(getApplVerID());
//    }

//    @XmlTransient
//    private ApplVerID getApplVerID() {
//        ApplVerID fixVersion;
//        if (fixMessage.startsWith("8=FIX.4.0\u0001")) {
//            fixVersion = new ApplVerID(ApplVerID.FIX40);
//        } else if (fixMessage.startsWith("8=FIX.4.1\u0001")) {
//            fixVersion = new ApplVerID(ApplVerID.FIX41);
//        } else if (fixMessage.startsWith("8=FIX.4.2\u0001")) {
//            fixVersion = new ApplVerID(ApplVerID.FIX42);
//        } else if (fixMessage.startsWith("8=FIX.4.3\u0001")) {
//            fixVersion = new ApplVerID(ApplVerID.FIX43);
//        } else if (fixMessage.startsWith("8=FIX.4.4\u0001")) {
//            fixVersion = new ApplVerID(ApplVerID.FIX44);
//        } else {
//            throw new IllegalStateException("Unsupported FIX version " + fixMessage);
//        }
//        return fixVersion;
//    }

    public String toString() {
        if (fixMessage != null)
            return fixMessage.replaceAll("\u0001", "\r\n");
        else
            return "";
    }
}