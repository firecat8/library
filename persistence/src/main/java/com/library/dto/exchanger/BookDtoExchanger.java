/*
 * Project library
 */
package com.library.dto.exchanger;

import com.library.domain.book.Book;
import com.library.dto.BookDto;

/**
 *
 * @author gdimitrova
 */
public class BookDtoExchanger extends DtoEntityExchanger<BookDto, Book> {

    public final static BookDtoExchanger INSTANCE = new BookDtoExchanger();

    private BookDtoExchanger() {
    }

    @Override
    protected Book exchangeFrom(BookDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
// return new Book(title, ddcCode, BookStates.NEW, publisher, form, author, serie, dto.);
    }

    @Override
    protected BookDto exchangeFrom(Book e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
