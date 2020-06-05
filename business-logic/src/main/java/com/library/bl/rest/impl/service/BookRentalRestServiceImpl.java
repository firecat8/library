package com.library.bl.rest.impl.service;

import com.library.bl.rest.impl.CrudRestServiceImpl;
import com.library.bl.rest.impl.vo.exchanger.BookRentalVoExchanger;
import com.library.dao.BookRentalDao;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.domain.book.BookRental;
import com.library.rest.api.service.BookRentalRestService;
import com.library.rest.api.vo.book.BookRentalVo;
import com.library.rest.api.vo.list.BooksRentalListVo;

/**
 *
 * @author gdimitrova
 */
public class BookRentalRestServiceImpl extends CrudRestServiceImpl<BookRentalDao, BookRentalVo, BookRental, BooksRentalListVo>
        implements BookRentalRestService {

    public BookRentalRestServiceImpl(DaoRegistryFactory factory) {
        super(factory,
                BookRentalVoExchanger.INSTANCE,
                BooksRentalListVo::new,
                DaoRegistry::getBookRentalDao
        );
    }

}
