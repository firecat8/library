package com.library.domain.user;

/**
 *
 * @author gdimitrova
 */
public class Reader extends Person {

    public Reader() {
    }

    public Reader(String firstName, String surname, String lastName, String phoneNumber, String userName, String password, String email) {
        super(firstName, surname, lastName, phoneNumber, userName, password, email, Roles.READER);
    }

}
