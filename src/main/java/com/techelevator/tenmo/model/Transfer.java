package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {
    private int transferId;
    private BigDecimal amount;
    private String status;
    private int accountId_from;
    private int accountId_to;

    public Transfer(int transferId, BigDecimal amount, String status, int accountId_from, int accountId_to) {
        this.transferId = transferId;
        this.amount = amount;
        this.status = status;
        this.accountId_from = accountId_from;
        this.accountId_to = accountId_to;
    }

    public Transfer() {

    }

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAccountId_from() {
        return accountId_from;
    }

    public void setAccountId_from(int accountId_from) {
        this.accountId_from = accountId_from;
    }

    public int getAccountId_to() {
        return accountId_to;
    }

    public void setAccountId_to(int accountId_to) {
        this.accountId_to = accountId_to;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "transferId=" + transferId +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", accountId_from=" + accountId_from +
                ", accountId_to=" + accountId_to +
                '}';
    }
}
