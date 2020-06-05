package com.library.bl.rest.impl.service;

import com.library.bl.rest.impl.CrudRestServiceImpl;
import com.library.bl.rest.impl.vo.exchanger.BookVoExchanger;
import com.library.dao.BookDao;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.domain.book.Book;
import com.library.rest.api.service.BookRestService;
import com.library.rest.api.vo.book.BookVo;
import com.library.rest.api.vo.list.BooksListVo;

/**
 *
 * @author gdimitrova
 */
public class BookRestServiceImpl extends CrudRestServiceImpl<BookDao, BookVo, Book, BooksListVo>
        implements BookRestService {

    public BookRestServiceImpl(DaoRegistryFactory factory) {
        super(factory,
                BookVoExchanger.INSTANCE,
                BooksListVo::new,
                DaoRegistry::getBookDao
        );
    }

}
