/*
 * Project library
 */
package com.library.bl.rest.impl.vo.exchanger;

import com.library.domain.book.Publisher;
import com.library.rest.api.vo.book.PublisherVo;

/**
 *
 * @author gdimitrova
 */
public class PublisherVoExchanger extends VoEntityExchanger<PublisherVo, Publisher> {

    public final static PublisherVoExchanger INSTANCE = new PublisherVoExchanger();

    private PublisherVoExchanger() {
    }

    @Override
    protected Publisher exchangeFrom(PublisherVo Vo) {
        return new Publisher(Vo.getName());
    }

    @Override
    protected PublisherVo exchangeFrom(Publisher e) {
        return new PublisherVo(e.getName());
    }

}
