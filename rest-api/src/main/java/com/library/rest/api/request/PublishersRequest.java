package com.library.rest.api.request;

import com.library.domain.book.Publisher;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class PublishersRequest extends EntityListRequest<Publisher>{
    
    public PublishersRequest(List<Publisher> entities) {
        super(entities);
    }
    
}
