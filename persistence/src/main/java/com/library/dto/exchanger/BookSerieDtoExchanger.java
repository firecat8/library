/*
 * Project library
 */
package com.library.dto.exchanger;

import com.library.domain.book.BookSerie;
import com.library.dto.BookSerieDto;

/**
 *
 * @author gdimitrova
 */
public class BookSerieDtoExchanger extends DtoEntityExchanger<BookSerieDto, BookSerie> {

    @Override
    protected BookSerie exchangeFrom(BookSerieDto dto) {
        return new BookSerie(dto.getName());
    }

    @Override
    protected BookSerieDto exchangeFrom(BookSerie e) {
        return new BookSerieDto(e.getName());
    }

}
