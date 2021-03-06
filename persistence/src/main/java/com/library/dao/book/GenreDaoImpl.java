/*
 * Project library
 */
package com.library.dao.book;

import com.library.dao.AbstractCrudDao;
import com.library.dao.GenreDao;
import com.library.domain.book.Genre;
import com.library.dto.GenreDto;
import com.library.dto.exchanger.GenreDtoExchanger;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author gdimitrova
 */
public class GenreDaoImpl extends AbstractCrudDao<GenreDto, Genre> implements GenreDao {

    public GenreDaoImpl(EntityManager em) {
        super(GenreDto.class, em, GenreDtoExchanger.INSTANCE);
    }

    @Override
    protected Map<String, Object> loadProperties(GenreDto newOne) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", newOne.getName());
        return map;
    }

}
