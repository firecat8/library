package com.library.rest.api.request;

import com.library.rest.api.vo.book.PublisherVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class PublishersRequest extends EntityListRequest<PublisherVo>{
    
    public PublishersRequest(List<PublisherVo> entities) {
        super(entities);
    }
    
}
