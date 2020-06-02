package com.library.rest.api.vo.list;

import com.library.rest.api.vo.EntityListVo;
import com.library.rest.api.vo.book.PublisherVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class PublishersListVo extends EntityListVo<PublisherVo>{

    public PublishersListVo() {
    }

    public PublishersListVo(List<PublisherVo> entities) {
        super(entities);
    }
    
}
