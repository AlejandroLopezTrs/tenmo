package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Balance;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.security.jwt.TokenProvider;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    //TODO: get all users method

    private final TokenProvider tokenProvider;
    private UserDao userDao;
    public UserController(TokenProvider tokenProvider, UserDao userDao){
        this.tokenProvider = tokenProvider;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/api/tenmo/user/list", method = RequestMethod.GET)
    public List<User> allUsers(){
        return userDao.findAll();
        //TODO: this works pretty well, displays all info. May need to cull some info to fit tests.
    }

}
