package com.techelevator.tenmo.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("isAuthenticated")
public class TransferController {
    //TODO: implement GETs and such to transfer controller.
}