package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Balance;
import com.techelevator.tenmo.security.jwt.TokenProvider;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    //TODO: get all users method

    private final TokenProvider tokenProvider;
    private UserDao userDao;
    public UserController(TokenProvider tokenProvider, UserDao userDao){
        this.tokenProvider = tokenProvider;
        this.userDao = userDao;
    }
}
