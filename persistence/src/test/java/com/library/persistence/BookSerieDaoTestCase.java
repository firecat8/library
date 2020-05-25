/*
 * Project library
 */
package com.library.persistence;

import com.library.dao.DaoRegistry;
import com.library.dao.book.BookSerieDaoImpl;
import com.library.domain.book.BookSerie;
import com.library.dto.BookSerieDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class BookSerieDaoTestCase extends AbstractCrudDaoTestCase<BookSerieDto, BookSerie, BookSerieDaoImpl> {

    @Override
    protected BookSerie createEntity() {
        return createEntity("New Species");
    }

    @Override
    protected List<BookSerie> createEntities() {
        return createBookSeries();
    }

    @Override
    protected BookSerieDaoImpl getDao(DaoRegistry registry) {
        return (BookSerieDaoImpl) registry.getBookSerieDao();
    }

    private static BookSerie createEntity(String name) {
        return new BookSerie(name);
    }

    public static List<BookSerie> createBookSeries() {
        List<BookSerie> bookSeries = new ArrayList<>();
        bookSeries.add(createEntity("Avalon"));
        bookSeries.add(createEntity("Mackade Brothers"));
        return bookSeries;
    }

    @Override
    protected void prepareDbData() {
    }
}
