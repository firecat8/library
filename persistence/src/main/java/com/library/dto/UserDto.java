/*
 * Project library
 */
package com.library.dto;

import com.library.domain.user.Roles;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gdimitrova
 */
@Entity(name = "users")
@Table(name = "users")
public class UserDto extends AbstractDto {

    public static final String USERNAME = "username";

    public static final String PASSWORD = "password";

    public static final String EMAIL = "email";

    public static final String ROLE = "user_role";

    public static final String FIRST_NAME = "first_name";

    public static final String SURNAME = "surname";

    public static final String LAST_NAME = "last_name";

    public static final String PHONE_NUMBER = "phone_number";

    public static final String USERNAME_PROP = "userName";

    public static final String PASSWORD_PROP = "password";

    public static final String ROLE_PROP = "role";

    public static final String CREATED_DATE = "created_date";

    @Column(name = USERNAME, unique = true, nullable = false)
    private String userName;

    @Column(name = PASSWORD, nullable = false)
    private String password;

    @Column(name = EMAIL, unique = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = ROLE)
    private Roles role;

    @Column(name = FIRST_NAME, nullable = false)

    private String firstName;

    @Column(name = SURNAME, nullable = false)
    private String surname;

    @Column(name = LAST_NAME, nullable = false)
    private String lastName;

    @Column(name = PHONE_NUMBER, nullable = false)
    private String phoneNumber;

    @Column(name = CREATED_DATE, nullable = false)
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdDate;

    public UserDto() {
        //Hibernate
    }

    public UserDto(String userName, String password, String email, Roles role, String firstName, String surname, String lastName, String phoneNumber,Calendar createdDate) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
        this.firstName = firstName;
        this.surname = surname;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.createdDate=createdDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
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

    public Calendar getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Calendar createdDate) {
        this.createdDate = createdDate;
    }

}
