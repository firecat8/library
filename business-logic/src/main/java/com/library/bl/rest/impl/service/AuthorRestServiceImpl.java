package com.library.bl.rest.impl.service;

import com.library.bl.rest.impl.CrudRestServiceImpl;
import com.library.bl.rest.impl.vo.exchanger.AuthorVoExchanger;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.dao.AuthorDao;
import com.library.domain.book.Author;
import com.library.rest.api.service.AuthorRestService;
import com.library.rest.api.vo.book.AuthorVo;
import com.library.rest.api.vo.list.AuthorsListVo;

/**
 *
 * @author gdimitrova
 */
public class AuthorRestServiceImpl extends CrudRestServiceImpl<AuthorDao, AuthorVo, Author, AuthorsListVo>
        implements AuthorRestService {

    public AuthorRestServiceImpl(DaoRegistryFactory factory) {
        super(factory,
                AuthorVoExchanger.INSTANCE,
                AuthorsListVo::new,
                DaoRegistry::getAuthorDao
        );
    }

}
