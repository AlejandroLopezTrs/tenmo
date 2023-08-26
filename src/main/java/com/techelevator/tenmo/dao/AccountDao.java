package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountDao {

    List<Account> getAllAccounts();
    Account getAccountById(int id);
    BigDecimal addToReceiver(BigDecimal addedAmount, int accountIdTo);
    BigDecimal subtractFromSender(BigDecimal subtractedAmount, int accountIdFrom);
    BigDecimal getBalance(String username);


    // Account createAccount(Account account); //TODO: IMPLEMENT FUNCTIONALITY DURING A FUTURE UPDATE


} //TODO: finish implementing account dao

