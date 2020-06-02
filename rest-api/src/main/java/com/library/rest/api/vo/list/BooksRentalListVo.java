package com.library.rest.api.vo.list;

import com.library.rest.api.vo.EntityListVo;
import com.library.rest.api.vo.book.BookRentalVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class BooksRentalListVo extends EntityListVo<BookRentalVo>{

    public BooksRentalListVo() {
    }

    public BooksRentalListVo(List<BookRentalVo> entities) {
        super(entities);
    }
    
}
