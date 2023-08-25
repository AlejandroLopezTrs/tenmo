package com.techelevator.tenmo.exceptions;

public class InvalidUserException extends Exception{
    public InvalidUserException(){
        super("Error: Invalid User.");
    }
}
