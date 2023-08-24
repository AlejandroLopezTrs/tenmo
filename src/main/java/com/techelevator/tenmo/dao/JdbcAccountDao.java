package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcAccountDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Account> getAllAccounts() {
        List<Account> allAccounts = new ArrayList<>();
        String sql = "SELECT account_id, user_id, balance FROM account;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while ((results.next())){
            Account account = mapRowToAccount(results);
            allAccounts.add(account);
        }

        return allAccounts;
    }

    @Override
    public Account getAccountById(int id) {
        String sql = "SELECT account_id, user_id, balance FROM account WHERE account_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        Account account = null;
        if (results.next()) {
            account = mapRowToAccount(results);
        }

        return account;
    }

    @Override
    public Account createAccount(Account account) {
        return null;
    }

    @Override
    public BigDecimal getBalance(int userId) {
        String sql = "SELECT balance FROM account WHERE account_id = ?";
        SqlRowSet results =
        return null;
    }

    private Account mapRowToAccount(SqlRowSet rs) {
        Account account = new Account();
        account.setAccountId(rs.getInt("account_id"));
        account.setUserId(rs.getInt("user_id"));
        account.setBalance(rs.getDouble("balance"));
        return account;
    }

}
