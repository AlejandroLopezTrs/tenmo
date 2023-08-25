package com.techelevator.tenmo.exceptions;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(){
        super("Error: Insufficient funds. Cannot complete transaction");
    }
}
