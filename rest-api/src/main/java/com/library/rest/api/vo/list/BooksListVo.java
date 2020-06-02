package com.library.rest.api.vo.list;

import com.library.rest.api.vo.EntityListVo;
import com.library.rest.api.vo.book.BookVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class BooksListVo extends EntityListVo<BookVo>{

    public BooksListVo() {
    }

    public BooksListVo(List<BookVo> entities) {
        super(entities);
    }
    
}
