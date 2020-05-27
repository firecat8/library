/*
 * Project library
 */
package com.library.bl.rest.impl.vo.exchanger;

import com.library.domain.book.BookSerie;
import com.library.rest.api.vo.book.BookSerieVo;

/**
 *
 * @author gdimitrova
 */
public class BookSerieVoExchanger extends VoEntityExchanger<BookSerieVo, BookSerie> {

    public final static BookSerieVoExchanger INSTANCE = new BookSerieVoExchanger();

    private BookSerieVoExchanger() {
    }

    @Override
    protected BookSerie exchangeFrom(BookSerieVo Vo) {
        return new BookSerie(Vo.getName());
    }

    @Override
    protected BookSerieVo exchangeFrom(BookSerie e) {
        return new BookSerieVo(e.getName());
    }

}
