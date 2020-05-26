/*
 * Project library
 */
package com.library.dto.exchanger;

import com.library.domain.book.Book;
import com.library.domain.book.BookRental;
import com.library.domain.user.User;
import com.library.dto.BookDto;
import com.library.dto.BookRentalDto;
import com.library.dto.UserDto;

/**
 *
 * @author gdimitrova
 */
public class BookRentalDtoExchanger extends DtoEntityExchanger<BookRentalDto, BookRental> {

    public final static BookRentalDtoExchanger INSTANCE = new BookRentalDtoExchanger();

    private BookRentalDtoExchanger() {
    }

    @Override
    protected BookRental exchangeFrom(BookRentalDto dto) {
        Book book = BookDtoExchanger.INSTANCE.exchange(dto.getBook());
        User user = UserDtoExchanger.INSTANCE.exchange(dto.getUser());
        return new BookRental(book, user, dto.getReceivableDate(), dto.getReturnDeadLine(), dto.getReturnDate());
    }

    @Override
    protected BookRentalDto exchangeFrom(BookRental e) {
        BookDto book = BookDtoExchanger.INSTANCE.exchange(e.getBook());
        UserDto user = UserDtoExchanger.INSTANCE.exchange(e.getUser());
        return new BookRentalDto(book, user, e.getReceivableDate(), e.getReturnDeadLine(), e.getReturnDate());
    }

}
