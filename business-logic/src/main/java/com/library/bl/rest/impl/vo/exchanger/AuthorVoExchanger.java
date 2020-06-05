/*
 * Project library
 */
package com.library.bl.rest.impl.vo.exchanger;

import com.library.domain.book.Author;
import com.library.rest.api.vo.book.AuthorVo;

/**
 *
 * @author gdimitrova
 */
public class AuthorVoExchanger extends VoEntityExchanger<AuthorVo, Author> {

    public final static AuthorVoExchanger INSTANCE = new AuthorVoExchanger();

    private AuthorVoExchanger() {
    }

    @Override
    protected Author exchangeFrom(AuthorVo Vo) {
        return new Author(Vo.getName(), Vo.getBiography(), Vo.getBirthPlace(),
                DateVoExchanger.INSTANCE.exchange(Vo.getBirthDate()));
    }

    @Override
    protected AuthorVo exchangeFrom(Author e) {
        return new AuthorVo(e.getName(), e.getBiography(), e.getBirthPlace(),
                DateVoExchanger.INSTANCE.exchange(e.getBirthdate()));
    }

}
