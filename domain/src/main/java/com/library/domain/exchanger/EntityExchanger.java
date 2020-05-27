package com.library.domain.exchanger;

import com.library.domain.Entity;
import java.util.List;

/**
 *
 * @author gdimitrova
 * @param <D>
 * @param <E>
 */
public interface EntityExchanger< D, E extends Entity> {

    public E exchange(D dto);

    public D exchange(E e);

    public E exchangeId(D from, E to);

    public D exchangeId(E from, D to);

    public List<D> exchangeEntityList(List<E> list);

    public List<E> exchangeList(List<D> list);
}
