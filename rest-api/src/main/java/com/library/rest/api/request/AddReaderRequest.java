package com.library.rest.api.request;

import com.library.domain.user.Reader;

/**
 *
 * @author gdimitrova
 */
public class AddReaderRequest extends ValueHolderRequest<Reader>{
    
    public AddReaderRequest(Reader value) {
        super(value);
    }
    
}
