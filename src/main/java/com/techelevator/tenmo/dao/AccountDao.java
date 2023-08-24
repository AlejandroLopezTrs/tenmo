package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import java.util.List;

public interface AccountDao {

    List<Account> getAllAccounts();
    Account getAccountById(int id);
    Account createAccount(Account account);
}
