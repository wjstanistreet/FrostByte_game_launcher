package com.example.frostbyte_game_launcher.models;

public class Reply {

    private String message;
    private Account accountStatus;

    public Reply(String message, Account accountStatus){
        this.message = message;
        this.accountStatus = accountStatus;
    }

    public Reply(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Account getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Account accountStatus) {
        this.accountStatus = accountStatus;
    }
}
