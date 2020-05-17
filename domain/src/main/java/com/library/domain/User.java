package com.library.domain;

/**
 *
 * @author gdimitrova
 */
public class User extends Entity {

    private String userName;

    private String password;

    private String email;

    private Roles role;

    public User() {
    }

    public User(String userName,  String password,String email, Roles role) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public boolean isAdministrator() {
        return role == Roles.ADMINISTRATOR;
    }

}
