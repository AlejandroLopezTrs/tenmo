package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class JdbcTransferDao implements TransferDao {
    private AccountDao accountDao;
    private JdbcTemplate jdbcTemplate;



    @Override
    public List<Transfer> getAllTransfers(int userId) {
        List<Transfer> allTransfers = new ArrayList<>();
        String sql = "SELECT transfer_id, amount, status, accountId_from, " +
                "accountId_to FROM transfer WHERE user_id = ?";
        return allTransfers;

    }

    @Override
    public Transfer getTransferByTransferId(int transactionId) {
        String sql = "SELECT transfer_id, amount, status, accountId_from, accountId_to " +
                "FROM transfer WHERE transfer_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        Transfer transferSearchedFor = null;
        if(results.next()){
            transferSearchedFor = mapRowToTransfer(results);
        }
        return transferSearchedFor;


    }


    //@Override
    //public Transfer getTransferStatus() {
    //    return null;
   // }

    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public Transfer newTransfer(int accountIdFrom, int accountIdTo, BigDecimal amount) {
        if(accountIdFrom == accountIdTo){
            System.out.println("Error: Cannot send money to the same account.");
        }
//        if(amount.compareTo(accountDao.getBalance(accountIdFrom)) > BigDecimal.ZERO)
//        String sql = "INSERT INTO transfer (amount, accountId_from, accountId_to) " +
//                "VALUES (?, ?, ?);";
        return null;
    }

    private Transfer mapRowToTransfer(SqlRowSet rs){
        Transfer transfer = new Transfer();
        transfer.setTransferId(rs.getInt("transfer_id"));
        transfer.setAmount(rs.getBigDecimal("amount"));
        transfer.setAccountId_from(rs.getInt("accountId_from"));
        transfer.setAccountId_to(rs.getInt("accountId_to"));
        return transfer;
    }
}
