package com.library.rest.api.vo.book;

import com.library.rest.api.vo.AbstractVo;
import com.library.rest.api.vo.user.UserVo;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author gdimitrova
 */
public class BookRentalVo extends AbstractVo {

    private BookVo book;

    private UserVo user;

    private Calendar receivableDate;

    private Calendar returnDeadLine;

    private Calendar returnDate;

    public BookRentalVo(BookVo book, UserVo user, Calendar receivableDate, Calendar returnDeadLine, Calendar returnDate) {
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

    public Calendar getReceivableDate() {
        return receivableDate;
    }

    public void setReceivableDate(Calendar receivableDate) {
        this.receivableDate = receivableDate;
    }

    public Calendar getReturnDeadLine() {
        return returnDeadLine;
    }

    public void setReturnDeadLine(Calendar returnDeadLine) {
        this.returnDeadLine = returnDeadLine;
    }

    public Calendar getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Calendar returnDate) {
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

}
