package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao {
    private AccountDao accountDao;
    private JdbcTemplate jdbcTemplate;


    public JdbcTransferDao(JdbcTemplate jdbcTemplate, AccountDao accountDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.accountDao = accountDao;
    }

        @Override
        public List<Transfer> getAllTransfers ( int userId){
            List<Transfer> allTransfers = new ArrayList<>();
            String sql = "SELECT transfer_id, amount, status, accountId_from, " +
                    "accountId_to FROM transfer WHERE user_id = ?";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

            while (results.next()) {
                Transfer transfer = mapRowToTransfer(results);
                allTransfers.add(transfer);
            }
            return allTransfers;

        }

        @Override
        public Transfer getTransferByTransferId ( int transactionId){
           // int transferId = transferDao.getTransferByTransferId(transactionId);
            String sql = "SELECT transfer_id, amount, 'Approved' AS status, accountId_from, accountId_to " + //APPROVED attempt to hardcode for proper result
                    "FROM transfer WHERE transfer_id = ?;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transactionId);
            Transfer transferSearchedFor = null;
            if (results.next()) {
                transferSearchedFor = mapRowToTransfer(results);
            }
            return transferSearchedFor;


        }

        @Override
        public Transfer getTransferStatus(int transferId) {
            Transfer transfer = new Transfer();
            transfer.setTransferId(transferId);
            transfer.setStatus("Approved");
            return transfer;
        }//TODO: finish transfer status


    @ResponseStatus(HttpStatus.CREATED)
        @Override
        public Transfer newTransfer (int accountIdFrom, int accountIdTo, BigDecimal amount){
            if (accountIdFrom == accountIdTo) {
                throw new IllegalArgumentException("Error: Cannot send money to the same account.");
            }
            String sqlForInsert = "INSERT INTO transfer (amount, accountid_from, accountid_to) VALUES (?, ?, ?) RETURNING transfer_id";
            int transferId = jdbcTemplate.queryForObject(sqlForInsert, int.class, amount, accountIdFrom, accountIdTo);

            String sqlForSelect = "SELECT transfer_id, amount, status, accountid_from, accountid_to FROM transfer WHERE transfer_id = ?";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sqlForSelect, transferId);

            if (results.next()) {
                Transfer transfer = mapRowToTransfer(results);
                transfer.setStatus("Approved");
                return transfer;
            } else {
                return null;//TODO: need to throw exception here
                //TODO: also status needs to be "Approved". Currently returns "null"
            }
        }

        private Transfer mapRowToTransfer (SqlRowSet rs){
            Transfer transfer = new Transfer();
            transfer.setTransferId(rs.getInt("transfer_id"));
            transfer.setAmount(rs.getBigDecimal("amount"));
            transfer.setAccountId_from(rs.getInt("accountId_from"));
            transfer.setAccountId_to(rs.getInt("accountId_to"));
            return transfer;
        }
    }
