package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.ArrayList;
import java.util.List;


public class JdbcTransferDao implements TransferDao {

    @Override
    public List<Transfer> getAllTransfers(int userId) {
        List<Transfer> list = new ArrayList<>();
        String sql = "SELECT ";
        return list;

    }

    @Override
    public Transfer getTransferByTransferId(int transactionId) {
        Transfer transfer = new Transfer( );
        String sql = "SELECT";
        return null;


    }


    @Override
    public Transfer getTransferStatus() {
        return null;
    }

    @Override
    public Transfer newTransfer() {
        return null;
    }
}
