package com.library.domain.book;

import com.library.domain.Entity;
import java.util.Calendar;

/**
 *
 * @author gdimitrova
 */
public class BorrowedBook extends Entity {

    private Book book;

    private Calendar receivableDate;

    private Calendar returnDate;

    public BorrowedBook(Book book, Calendar receivableDate, Calendar returnDate) {
        this.receivableDate = receivableDate;
        this.returnDate = returnDate;
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Calendar getReceivableDate() {
        return receivableDate;
    }

    public void setReceivableDate(Calendar receivableDate) {
        this.receivableDate = receivableDate;
    }

    public Calendar getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Calendar returnDate) {
        this.returnDate = returnDate;
    }

}
