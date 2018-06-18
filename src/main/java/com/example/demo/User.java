package com.example.demo;

public class User {
    private String username;
    private float balance;

    public void setUsername(String username){
        this.username=username;
    }

    public void setBalance(int balance){
        this.balance=balance;
    }

    public String getUsername(){
        return username;
    }

    public float getBalance(){
        return balance;
    }
}
