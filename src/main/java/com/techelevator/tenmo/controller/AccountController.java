package com.techelevator.tenmo.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;

@RestController
@PreAuthorize("isAuthenticated")
public class AccountController {

@RequestMapping(path = "api/tenmo/account/balance", method = RequestMethod.GET)
    public String getBalance(Principal principal){
    return principal.getName();
}
}
