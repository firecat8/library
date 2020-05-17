package com.library.domain;

/**
 *
 * @author gdimitrova
 */
public class Operator extends Person {

    public Operator(String firstName, String surname, String lastName, String phoneNumber, String userName, String password, String email, boolean isAdmin) {
        super(firstName, surname, lastName, phoneNumber, userName, password, email, isAdmin ? Roles.ADMINISTRATOR : Roles.OPERATOR);
    }

    private Operator(String firstName, String surname, String lastName, String phoneNumber, String userName, String password, String email, Roles role) {
        super(firstName, surname, lastName, phoneNumber, userName, password, email, role);
    }
}
