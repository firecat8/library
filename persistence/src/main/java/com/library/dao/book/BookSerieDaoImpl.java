/*
 * Project library
 */
package com.library.dao.book;

import com.library.dao.AbstractCrudDao;
import com.library.dao.BookSerieDao;
import com.library.domain.book.BookSerie;
import com.library.dto.BookSerieDto;
import com.library.dto.exchanger.BookSerieDtoExchanger;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author gdimitrova
 */
public class BookSerieDaoImpl extends AbstractCrudDao<BookSerieDto, BookSerie> implements BookSerieDao {

    public BookSerieDaoImpl(EntityManager em) {
        super(BookSerieDto.class, em, BookSerieDtoExchanger.INSTANCE);
    }

    @Override
    protected Map<String, Object> loadProperties(BookSerieDto newOne) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", newOne.getName());
        return map;
    }

}
