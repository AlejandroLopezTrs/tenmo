package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDao {
    List<Transfer> getAllTransfers();
    Transfer getTransferByTransferId();
    Transfer getTransferStatus();
    Transfer newTransfer();


}
