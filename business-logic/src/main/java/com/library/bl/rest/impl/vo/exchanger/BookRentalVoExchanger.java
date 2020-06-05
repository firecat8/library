/*
 * Project library
 */
package com.library.bl.rest.impl.vo.exchanger;

import com.library.domain.book.Book;
import com.library.domain.book.BookRental;
import com.library.domain.user.User;
import com.library.rest.api.vo.book.BookRentalVo;
import com.library.rest.api.vo.book.BookVo;
import com.library.rest.api.vo.user.UserVo;

/**
 *
 * @author gdimitrova
 */
public class BookRentalVoExchanger extends VoEntityExchanger<BookRentalVo, BookRental> {

    public final static BookRentalVoExchanger INSTANCE = new BookRentalVoExchanger();

    private BookRentalVoExchanger() {
    }

    @Override
    protected BookRental exchangeFrom(BookRentalVo Vo) {
        Book book = BookVoExchanger.INSTANCE.exchange(Vo.getBook());
        User user = UserVoExchanger.INSTANCE.exchange(Vo.getUser());
        return new BookRental(book, user, 
                DateVoExchanger.INSTANCE.exchange(Vo.getReceivableDate()),
                DateVoExchanger.INSTANCE.exchange(Vo.getReturnDeadLine()),
                DateVoExchanger.INSTANCE.exchange(Vo.getReturnDate()));
    }

    @Override
    protected BookRentalVo exchangeFrom(BookRental e) {
        BookVo book = BookVoExchanger.INSTANCE.exchange(e.getBook());
        UserVo user = UserVoExchanger.INSTANCE.exchange(e.getUser());
        return new BookRentalVo(book, user, 
                DateVoExchanger.INSTANCE.exchange(e.getReceivableDate()),
                DateVoExchanger.INSTANCE.exchange(e.getReturnDeadLine()),
                DateVoExchanger.INSTANCE.exchange(e.getReturnDate()));
    }

    
}
