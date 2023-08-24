package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfers;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

public class JdbcTransfersDao {

    @Component
    public class JdbcTransfers implements TransfersDao {
        @Override
        public List<Transfers> getAllTransfers(int userID) {
            return null;
        }

        @Override
        public Transfers getTransferByID(int transactionID) {
            return null;
        }

        @Override
        public String transferMoney(BigDecimal amount) {
            return null;
        }

        //TODO: finish implementing class for data bass connection.
    }
}
