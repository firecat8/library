package com.library.dto.exchanger;

import com.library.dto.AbstractDto;
import com.library.domain.Entity;
import com.library.domain.exchanger.AbstractDtoEntityExchanger;

/**
 *
 * @author gdimitrova
 * @param <D>
 * @param <E>
 */
public abstract class DtoEntityExchanger<D extends AbstractDto, E extends Entity> extends AbstractDtoEntityExchanger<D, E> {

    @Override
    public E exchangeId(D from, E to) {
        to.setId(from.getId());
        return to;
    }

    @Override
    public D exchangeId(E from, D to) {
        to.setId(from.getId());
        return to;
    }

}
