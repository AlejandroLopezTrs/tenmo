package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class AccountController {

    @Autowired
    private AccountDao accountDao;

    public AccountController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @RequestMapping(path = "/api/tenmo/account/balance/{id}", method = RequestMethod.GET)
    public BigDecimal getBalance(@PathVariable int id){
        BigDecimal balance = accountDao.getBalanceForAccountById(id);
        if (balance == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error: Account does not exist.");
        }
        //TODO: return proper format with username and balance, currently only returns balance.
        //TODO: Transfers do not subtract money from total balance.
        return balance;
}

//GET ALL ACCOUNTS

    @RequestMapping(path = "/api/tenmo/account",method = RequestMethod.GET)
    List<Account> allAccounts(){
        List<Account> listAllAccounts = accountDao.getAllAccounts();

        return listAllAccounts;
    }

    //GET account by ID
    @RequestMapping(path = "api/tenmo/account/{id}", method = RequestMethod.GET)
    public Account getAccountByAccountId(@PathVariable int id){
        Account account = accountDao.getAccountById(id);
        if(account == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error: Account does not exist.");
        }else{
            return account;
        }
    }


}
