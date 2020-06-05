/*
 * Project library
 */
package com.library.dao.book;

import com.library.dao.AbstractCrudDao;
import com.library.dao.AuthorDao;
import com.library.domain.book.Author;
import com.library.dto.AuthorDto;
import com.library.dto.exchanger.AuthorDtoExchanger;
import java.util.HashMap;
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
        Map<String, Object> props = new HashMap<>();
        props.put(AuthorDto.BIOGRAPHY_PROP, newOne.getBiography());
        props.put(AuthorDto.BIRTH_DATE_PROP, newOne.getBirthdate());
        props.put(AuthorDto.BIRTH_PLACE_PROP, newOne.getBirthPlace());
        return props;
    }

}
