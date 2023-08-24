package com.techelevator.tenmo.model;

public class Balance {

    private String userName;
    private double balance;

    public Balance(String userName, Double balance){
        this.userName = userName;
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "userName='" + userName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
