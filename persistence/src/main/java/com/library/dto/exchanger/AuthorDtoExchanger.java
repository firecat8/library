/*
 * Project library
 */
package com.library.dto.exchanger;

import com.library.domain.user.Author;
import com.library.dto.AuthorDto;

/**
 *
 * @author gdimitrova
 */
public class AuthorDtoExchanger extends DtoEntityExchanger<AuthorDto, Author> {

    @Override
    protected Author exchangeFrom(AuthorDto dto) {
        return new Author(dto.getName(),dto.getBiography(),dto.getBirthPlace(),dto.getBirthdate());
    }

    @Override
    protected AuthorDto exchangeFrom(Author e) {
        return new AuthorDto(e.getName(),e.getBiography(),e.getBirthPlace(),e.getBirthdate());
    }

}
