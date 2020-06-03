package com.library.rest.api.request;

import java.io.Serializable;

/**
 *
 * @author gdimitrova
 */
public class LoginRequest implements Serializable{
    
    private String username;
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginRequest() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }



  
}
