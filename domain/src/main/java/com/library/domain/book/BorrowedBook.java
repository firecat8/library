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

    private Calendar returnDeadLine;

    private Calendar returnDate;

    private BookStatus status;

    public BorrowedBook(Book book, Calendar receivableDate, Calendar returnDeadLine, Calendar returnDate, BookStatus status) {
        this.book = book;
        this.receivableDate = receivableDate;
        this.returnDeadLine = returnDeadLine;
        this.returnDate = returnDate;
        this.status = status;
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

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

}
