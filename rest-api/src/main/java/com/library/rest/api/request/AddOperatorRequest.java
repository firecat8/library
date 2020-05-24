package com.library.rest.api.request;

import com.library.domain.user.Operator;

/**
 *
 * @author gdimitrova
 */
public class AddOperatorRequest extends ValueHolderRequest<Operator> {
    
    public AddOperatorRequest(Operator value) {
        super(value);
    }
    
}
