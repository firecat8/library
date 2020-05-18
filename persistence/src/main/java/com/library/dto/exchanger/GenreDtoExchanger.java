/*
 * Project library
 */
package com.library.dto.exchanger;

import com.library.domain.Genre;
import com.library.dto.GenreDto;

/**
 *
 * @author gdimitrova
 */
public class GenreDtoExchanger extends DtoEntityExchanger<GenreDto, Genre> {

    @Override
    protected Genre exchangeFrom(GenreDto dto) {
        return new Genre(dto.getName());
    }

    @Override
    protected GenreDto exchangeFrom(Genre e) {
        return new GenreDto(e.getName());
    }

}
