package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.model.Balance;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    //TODO: get all users method

    @RequestMapping(value = "/api/tenmo/balance", method = RequestMethod.GET)
    public Balance getAccountBalance (@RequestBody Balance newBalance) {


    }
}
