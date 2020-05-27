package com.library.bl.rest.impl.vo.exchanger;

import com.library.domain.Entity;
import com.library.domain.exchanger.AbstractEntityExchanger;
import com.library.rest.api.vo.AbstractVo;

/**
 *
 * @author gdimitrova
 * @param <Vo>
 * @param <E>
 */
public abstract class VoEntityExchanger<Vo extends AbstractVo, E extends Entity> extends AbstractEntityExchanger<Vo, E> {

    @Override
    public E exchangeId(Vo from, E to) {
        to.setId(from.getId());
        return to;
    }

    @Override
    public Vo exchangeId(E from, Vo to) {
        to.setId(from.getId());
        return to;
    }

}
