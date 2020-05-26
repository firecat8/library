/*
 * Project library
 */
package com.library.dto;

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gdimitrova
 */
@Entity(name = "book_rentals")
@Table(name = "book_rentals")
public class BookRentalDto extends AbstractDto {

    public final static String BOOK = "book_id";

    public final static String USER = "user_id";

    public final static String RECEIVABLE_DATE = "receivableDate";

    public final static String RETURN_DEAD_LINE = "returnDeadLine";

    public final static String RETURN_DATE = "returnDate";

    @ManyToOne()
    @JoinColumn(name = BOOK, nullable = false)
    private BookDto book;

    @ManyToOne
    @JoinColumn(name = USER, nullable = false)
    private UserDto user;

    @Column(name = RECEIVABLE_DATE, nullable = false)
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar receivableDate;

    @Column(name = RETURN_DEAD_LINE, nullable = false)
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar returnDeadLine;

    @Column(name = RETURN_DATE)
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar returnDate;

    public BookRentalDto() {
        //Hibernate
    }

    public BookRentalDto(BookDto book, UserDto user, Calendar receivableDate, Calendar returnDeadLine, Calendar returnDate) {
        this.book = book;
        this.user = user;
        this.receivableDate = receivableDate;
        this.returnDeadLine = returnDeadLine;
        this.returnDate = returnDate;
    }

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto book) {
        this.book = book;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
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

}
