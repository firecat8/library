package com.library.rest.api.request;

/**
 *
 * @author gdimitrova
 * @param <T>
 */
public abstract class ValueHolderRequest<T> {

    private final T value;

    public ValueHolderRequest(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

}
