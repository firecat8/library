package com.library.rest.api.vo.book;

import com.library.rest.api.vo.AbstractVo;
import com.library.rest.api.vo.DateVo;
import com.library.rest.api.vo.user.UserVo;
import java.util.Objects;
import java.util.Set;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author gdimitrova
 */
public class BookRentalVo extends AbstractVo {

    private BookVo book;

    private UserVo user;

    private DateVo receivableDate;

    private DateVo returnDeadLine;

    private DateVo returnDate;

    public BookRentalVo() {
    }

    public BookRentalVo(BookVo book, UserVo user, DateVo receivableDate, DateVo returnDeadLine, DateVo returnDate) {
        this.book = book;
        this.user = user;
        this.receivableDate = receivableDate;
        this.returnDeadLine = returnDeadLine;
        this.returnDate = returnDate;
    }

    public BookVo getBook() {
        return book;
    }

    public void setBook(BookVo book) {
        this.book = book;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    public DateVo getReceivableDate() {
        return receivableDate;
    }

    public void setReceivableDate(DateVo receivableDate) {
        this.receivableDate = receivableDate;
    }

    public DateVo getReturnDeadLine() {
        return returnDeadLine;
    }

    public void setReturnDeadLine(DateVo returnDeadLine) {
        this.returnDeadLine = returnDeadLine;
    }

    public DateVo getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(DateVo returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.book);
        hash = 29 * hash + Objects.hashCode(this.user);
        hash = 29 * hash + Objects.hashCode(this.receivableDate);
        hash = 29 * hash + Objects.hashCode(this.returnDeadLine);
        hash = 29 * hash + Objects.hashCode(this.returnDate);
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
        final BookRentalVo other = (BookRentalVo) obj;
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.receivableDate, other.receivableDate)) {
            return false;
        }
        if (!Objects.equals(this.returnDeadLine, other.returnDeadLine)) {
            return false;
        }
        if (this.returnDate == null && other.returnDate == null) {
            return true;
        }
        return Objects.equals(this.returnDate, other.returnDate);
    }

    @Override
    public Set<String> validate() {
        Set<String> errors = book.validate();
        errors.addAll(user.validate());
        errors.addAll(receivableDate.validate());
        errors.addAll(returnDeadLine.validate());
        if (returnDate != null) {
            errors.addAll(returnDate.validate());
        }
        return errors;
    }

}
