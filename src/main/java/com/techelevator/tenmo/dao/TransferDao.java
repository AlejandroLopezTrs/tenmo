package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.math.BigDecimal;
import java.util.List;

public interface TransferDao {
    List<Transfer> getAllTransfers(int userId);
    Transfer getTransferByTransferId(int transactionId);
    Transfer getTransferStatus(int transferId);//TODO: Needs to be implemented to say 'Approved' for now.

    Transfer newTransfer(int accountIdFrom, int accountIdTo, BigDecimal amount);

}
