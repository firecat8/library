package com.library.domain.user;

/**
 *
 * @author gdimitrova
 */
public class Person extends User {

    private String firstName;

    private String surname;

    private String lastName;

    private String phoneNumber;

    protected Person() {
    }

    protected Person(String firstName, String surname, String lastName, String phoneNumber, String userName, String password, String email, Roles role) {
        super(userName, password, email, role);
        this.firstName = firstName;
        this.surname = surname;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
