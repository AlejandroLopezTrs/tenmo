package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDao {
    List<Transfer> getAllTransfers(int userId);
    Transfer getTransferByTransferId(int transactionId);
    Transfer getTransferStatus();
    Transfer newTransfer();


}
