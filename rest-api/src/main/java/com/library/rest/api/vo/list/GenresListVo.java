package com.library.rest.api.vo.list;

import com.library.rest.api.vo.EntityListVo;
import com.library.rest.api.vo.book.GenreVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class GenresListVo  extends EntityListVo<GenreVo>{

    public GenresListVo() {
    }

    public GenresListVo(List<GenreVo> entities) {
        super(entities);
    }
    
}
