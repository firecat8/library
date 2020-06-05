package com.library.rest.api.vo.user;

import com.library.rest.api.vo.AbstractVo;
import com.library.rest.api.vo.DateVo;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author gdimitrova
 */
public class UserVo extends AbstractVo {

    private String userName;

    private String password;

    private String email;

    private RolesVo role;

    private String firstName;

    private String surname;

    private String lastName;

    private String phoneNumber;

    private DateVo createdDate;

    public UserVo() {
    }

    public UserVo(String userName, String password, String email, RolesVo role, String firstName, String surname, String lastName, String phoneNumber, DateVo createdDate) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
        this.firstName = firstName;
        this.surname = surname;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.createdDate = createdDate;
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

    public RolesVo getRole() {
        return role;
    }

    public void setRole(RolesVo role) {
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

    public DateVo getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateVo createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.userName);
        hash = 79 * hash + Objects.hashCode(this.password);
        hash = 79 * hash + Objects.hashCode(this.email);
        hash = 79 * hash + Objects.hashCode(this.role);
        hash = 79 * hash + Objects.hashCode(this.firstName);
        hash = 79 * hash + Objects.hashCode(this.surname);
        hash = 79 * hash + Objects.hashCode(this.lastName);
        hash = 79 * hash + Objects.hashCode(this.phoneNumber);
        hash = 79 * hash + Objects.hashCode(this.createdDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserVo other = (UserVo) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        if (this.role != other.role) {
            return false;
        }
        return Objects.equals(this.createdDate, other.createdDate);
    }

    @JsonIgnore
    public String getFullName() {
        return firstName.concat(" ").concat(surname).concat(" ").concat(lastName);
    }

    @Override
    public Set<String> validate() {
        Set<String> errors = checkForNull();
        if (!errors.isEmpty()) {
            return errors;
        }
        if (userName.isEmpty()) {
            errors.add("Empty userName.");
        }
        if (password.isEmpty()) {
            errors.add("Empty password.");
        }
        if (firstName.isEmpty()) {
            errors.add("Empty firstName.");
        }
        if (surname.isEmpty()) {
            errors.add("Empty surname.");
        }
        if (lastName.isEmpty()) {
            errors.add("Empty lastName.");
        }
        if (email.isEmpty()) {
            errors.add("Empty email.");
        }
        if (phoneNumber.isEmpty()) {
            errors.add("Empty phoneNumber.");
        }
        return errors;
    }
       public Set<String> checkForNull() {
        Set<String> errors = new HashSet<>();
        if (userName == null) {
            errors.add("userName is null.");
        }
        if (password == null) {
            errors.add("password is null.");
        }
        if (firstName == null) {
            errors.add("firstName is null.");
        }
        if (surname == null) {
            errors.add("surname is null.");
        }
        if (lastName == null) {
            errors.add("lastName is null.");
        }
        if (email == null) {
            errors.add("email is null.");
        }
        if (phoneNumber == null) {
            errors.add("phoneNumber is null.");
        }
        if (createdDate == null) {
            errors.add("createdDate is null.");
        }
        return errors;
    }
}
