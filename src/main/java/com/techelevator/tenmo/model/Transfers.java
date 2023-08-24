package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfers {

    private int transferId;
    private int status;
    private int accountIdFrom;
    private int accountIdTo;
    private BigDecimal amount;


    // TODO: Add any other instance variables and setters/getters

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAccountIdFrom() {
        return accountIdFrom;
    }

    public void setAccountIdFrom(int accountIdFrom) {
        this.accountIdFrom = accountIdFrom;
    }

    public int getAccountIdTo() {
        return accountIdTo;
    }

    public void setAccountIdTo(int accountIdTo) {
        this.accountIdTo = accountIdTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
