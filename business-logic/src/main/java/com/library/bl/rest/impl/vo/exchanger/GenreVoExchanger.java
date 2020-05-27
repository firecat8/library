/*
 * Project library
 */
package com.library.bl.rest.impl.vo.exchanger;

import com.library.domain.book.Genre;
import com.library.rest.api.vo.book.GenreVo;

/**
 *
 * @author gdimitrova
 */
public class GenreVoExchanger extends VoEntityExchanger<GenreVo, Genre> {

    public final static GenreVoExchanger INSTANCE = new GenreVoExchanger();

    private GenreVoExchanger() {
    }

    @Override
    protected Genre exchangeFrom(GenreVo Vo) {
        return new Genre(Vo.getName());
    }

    @Override
    protected GenreVo exchangeFrom(Genre e) {
        return new GenreVo(e.getName());
    }

}
