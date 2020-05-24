/*
 * Project library
 */
package com.library.dto.exchanger;

import com.library.domain.book.Publisher;
import com.library.dto.PublisherDto;

/**
 *
 * @author gdimitrova
 */
public class PublisherDtoExchanger extends DtoEntityExchanger<PublisherDto, Publisher> {

    public final static PublisherDtoExchanger INSTANCE = new PublisherDtoExchanger();

    private PublisherDtoExchanger() {
    }

    @Override
    protected Publisher exchangeFrom(PublisherDto dto) {
        return new Publisher(dto.getName());
    }

    @Override
    protected PublisherDto exchangeFrom(Publisher e) {
        return new PublisherDto(e.getName());
    }

}
