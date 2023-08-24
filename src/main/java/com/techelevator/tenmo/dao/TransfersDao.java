package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfers;

import java.math.BigDecimal;
import java.util.List;

public interface TransfersDao {

    public List<Transfers> getAllTransfers(int userID);
    public Transfers getTransferByID(int transactionID);

    public String transferMoney(BigDecimal amount);

    //TODO: finish implementing the Data base access and for checking information.

}
