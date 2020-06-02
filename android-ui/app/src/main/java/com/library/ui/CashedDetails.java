package com.library.ui;

public class CashedDetails {
    public final static CashedDetails INSTANCE = new CashedDetails();
    private String username="User7031719921";
    private String password="IBE5UJ?yYO";

    private CashedDetails() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
