package com.techelevator.tenmo.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("isAuthenticated")
public class TransferController {
    //TODO: implement GETs and such to transfer controller.

//    @RequestMapping(value = "/api/tenmo/transfer", method = RequestMethod.POST)
//    public void newTransfer(@RequestBody )
}
