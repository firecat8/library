package com.library.rest.api.request;

import com.library.rest.api.vo.book.PublisherVo;

/**
 *
 * @author gdimitrova
 */
public class PublisherRequest extends EntityRequest<PublisherVo>{
    
    public PublisherRequest(PublisherVo entity) {
        super(entity);
    }
    
}
