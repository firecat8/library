/*
 * Project library
 */
package com.library.dao.book;

import com.library.dao.AbstractCrudDao;
import com.library.dao.BookRentalDao;
import com.library.domain.book.BookRental;
import com.library.dto.BookRentalDto;
import com.library.dto.exchanger.BookRentalDtoExchanger;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author gdimitrova
 */
public class BookRentalDaoImpl extends AbstractCrudDao<BookRentalDto, BookRental> implements BookRentalDao {


    public BookRentalDaoImpl( EntityManager em ) {
        super(BookRentalDto.class, em, BookRentalDtoExchanger.INSTANCE);
    }

    @Override
    protected Map<String, Object> loadProperties(BookRentalDto newOne) {
        return new HashMap<>();
    }

}
