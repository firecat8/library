package com.library.rest.api.request;

import com.library.domain.book.Publisher;

/**
 *
 * @author gdimitrova
 */
public class PublisherRequest extends EntityRequest<Publisher>{
    
    public PublisherRequest(Publisher entity) {
        super(entity);
    }
    
}
