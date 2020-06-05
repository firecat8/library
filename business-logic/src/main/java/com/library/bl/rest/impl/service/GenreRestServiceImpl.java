package com.library.bl.rest.impl.service;

import com.library.bl.rest.impl.CrudRestServiceImpl;
import com.library.bl.rest.impl.vo.exchanger.GenreVoExchanger;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.dao.GenreDao;
import com.library.domain.book.Genre;
import com.library.rest.api.service.GenreRestService;
import com.library.rest.api.vo.book.GenreVo;
import com.library.rest.api.vo.list.GenresListVo;

/**
 *
 * @author gdimitrova
 */
public class GenreRestServiceImpl extends CrudRestServiceImpl<GenreDao, GenreVo, Genre, GenresListVo> implements GenreRestService{

    public GenreRestServiceImpl(DaoRegistryFactory factory) {
        super(factory,
                GenreVoExchanger.INSTANCE,
                GenresListVo::new,
                DaoRegistry::getGenreDao);
    }
}
