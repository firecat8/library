package com.library.domain.exchanger;

import com.library.domain.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author gdimitrova
 * @param <D>
 * @param <E>
 */
public abstract class AbstractDtoEntityExchanger< D, E extends Entity> implements DtoEntityExchanger<D, E> {

    @Override
    public E exchange(D dto) {
        return exchangeId(dto, exchangeFrom(dto));
    }

    @Override
    public D exchange(E e) {
        return exchangeId(e, exchangeFrom(e));
    }

    abstract protected E exchangeFrom(D dto);

    abstract protected D exchangeFrom(E e);

    @Override
    public List<D> exchangeEntityList(List<E> list) {
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        return list.stream().map(r -> this.exchange(r)).collect(Collectors.toList());
    }

    @Override
    public List<E> exchangeDtoList(List<D> list) {
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        return list.stream().map(r -> this.exchange(r)).collect(Collectors.toList());
    }

}
