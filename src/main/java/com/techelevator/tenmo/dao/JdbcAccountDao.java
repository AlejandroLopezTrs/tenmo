package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;
    private UserDao userDao;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> allAccounts = new ArrayList<>();
        String sql = "SELECT account_id, user_id, balance FROM account;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while ((results.next())) {
            Account account = mapRowToAccount(results);
            allAccounts.add(account);
        }

        return allAccounts;
    }

    @Override
    public Account getAccountById(int id) {
        String sql = "SELECT account_id, user_id, balance FROM account WHERE account_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        Account account = null;
        if (results.next()) {
            account = mapRowToAccount(results);
        }
        return account;
    }
    @Override
    public BigDecimal addToReceiver(BigDecimal addedAmount, int accountIdTo) {
        Account account = getAccountById(accountIdTo);
        BigDecimal newBalance = account.getBalance().add(addedAmount);
        String sql = "UPDATE account SET balance  = ? WHERE user_id = ?;";
        try {
            jdbcTemplate.update(sql, newBalance, accountIdTo);
        } catch (DataAccessException e) {
            System.out.println("Data access error");
        }
        return account.getBalance();
    }
    @Override
    public BigDecimal subtractFromSender(BigDecimal subtractedAmount, int accountIdFrom) {
        Account account = getAccountById(accountIdFrom);
        BigDecimal newBalance = account.getBalance().subtract(subtractedAmount);
        String sql = "UPDATE account SET balance  = ? WHERE user_id = ?;";
        try {
            jdbcTemplate.update(sql, newBalance, accountIdFrom);
        }catch (DataAccessException e) {
            System.out.println("Data access error");

        }
        return account.getBalance();
    }
    //@Override
    //public Account createAccount(Account account) {
    //    String sql = ""
   // }
    @Override
    public BigDecimal getBalance(String username) {
        int userId = userDao.findIdByUsername(username);
        String sql = "SELECT balance FROM account WHERE account_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        BigDecimal balance = null;
        if (results.next()) {
            balance = results.getBigDecimal("Balance");
        }
        return balance;
    }

    @Override
    public BigDecimal getBalanceForAccountById(int id) {
        String sql = "SELECT balance FROM account WHERE account_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        BigDecimal balance = null;
        if (results.next()) {
            balance = results.getBigDecimal("balance");
        }
        return balance;
    }

    private Account mapRowToAccount(SqlRowSet rs) {
        Account account = new Account();
        account.setAccountId(rs.getInt("account_id"));
        account.setUserId(rs.getInt("user_id"));
        account.setBalance(rs.getDouble("balance"));
        return account;
    }
}
