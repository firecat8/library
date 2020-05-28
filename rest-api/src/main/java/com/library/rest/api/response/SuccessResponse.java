package com.library.rest.api.response;

import java.io.Serializable;

/**
 *
 * @author gdimitrova
 */
public class SuccessResponse implements Serializable {

    private final boolean success = true;

    public SuccessResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

}
