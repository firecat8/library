/*
 * Project library
 */
package com.library.dao.book;

import com.library.dao.AbstractCrudDao;
import com.library.dao.AuthorDao;
import com.library.domain.book.Author;
import com.library.dto.AuthorDto;
import com.library.dto.exchanger.AuthorDtoExchanger;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author gdimitrova
 */
public class AuthorDaoImpl extends AbstractCrudDao<AuthorDto, Author> implements AuthorDao {

    public AuthorDaoImpl(EntityManager em) {
        super(AuthorDto.class, em, AuthorDtoExchanger.INSTANCE);
    }

    @Override
    protected Map<String, Object> loadProperties(AuthorDto newOne) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
