package com.library.bl.rest.impl.service;

import com.library.bl.rest.impl.CrudRestServiceImpl;
import com.library.bl.rest.impl.vo.exchanger.BookSerieVoExchanger;
import com.library.dao.BookSerieDao;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.domain.book.BookSerie;
import com.library.rest.api.service.BookSerieRestService;
import com.library.rest.api.vo.book.BookSerieVo;
import com.library.rest.api.vo.list.BookSeriesListVo;

/**
 *
 * @author gdimitrova
 */
public class BookSerieRestServiceImpl extends CrudRestServiceImpl<BookSerieDao, BookSerieVo, BookSerie, BookSeriesListVo>
        implements BookSerieRestService {

    public BookSerieRestServiceImpl(DaoRegistryFactory factory) {
        super(factory,
                BookSerieVoExchanger.INSTANCE,
                BookSeriesListVo::new,
                DaoRegistry::getBookSerieDao
        );
    }

}
