package com.library.domain;

/**
 *
 * @author gdimitrova
 */
public class Reader extends Person {

    private ReaderProfile readerProfile;

    public Reader() {
    }

    private Reader(String firstName, String surname, String lastName, String phoneNumber, String userName, String password, String email) {
        this(firstName, surname, lastName, phoneNumber, userName, password, email, new ReaderProfile());
    }

    private Reader(String firstName, String surname, String lastName, String phoneNumber, String userName, String password, String email, ReaderProfile readerProfile) {
        super(firstName, surname, lastName, phoneNumber, userName, password, email, Roles.READER);
        this.readerProfile = readerProfile;
    }

    public ReaderProfile getReaderProfile() {
        return readerProfile;
    }

    public void setReaderProfile(ReaderProfile readerProfile) {
        this.readerProfile = readerProfile;
    }

}
