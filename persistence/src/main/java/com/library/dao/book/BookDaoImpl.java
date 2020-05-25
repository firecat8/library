/*
 * Project library
 */
package com.library.dao.book;

import com.library.dao.AbstractCrudDao;
import com.library.dao.BookDao;
import com.library.domain.book.Book;
import com.library.dto.BookDto;
import com.library.dto.exchanger.BookDtoExchanger;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author gdimitrova
 */
public class BookDaoImpl extends AbstractCrudDao<BookDto, Book> implements BookDao {

    public BookDaoImpl(EntityManager em) {
        super(BookDto.class, em, BookDtoExchanger.INSTANCE);
    }

    @Override
    protected Map<String, Object> loadProperties(BookDto newOne) {
        return new HashMap<>();
    }

}
