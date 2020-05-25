/*
 * Project library
 */
package com.library.persistence;

import com.library.dao.DaoRegistry;
import com.library.dao.book.AuthorDaoImpl;
import com.library.domain.book.Author;
import com.library.dto.AuthorDto;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class AuthorDaoTestCase extends AbstractCrudDaoTestCase<AuthorDto, Author, AuthorDaoImpl> {

    @Override
    protected Author createEntity() {
        return createDefault();
    }

    @Override
    protected List<Author> createEntities() {
        return createAuthors();
    }

    @Override
    protected AuthorDaoImpl getDao(DaoRegistry registry) {
        return (AuthorDaoImpl) registry.getAuthorDao();
    }

    private static Author createEntity(String name, String biography, String birthPlace, Calendar birthDate) {
        return new Author(name, biography, birthPlace, birthDate);
    }

    public static Author createDefault() {
        return createEntity("Laurann Dohner", null, "Southern California, USA", new GregorianCalendar(1970, 5, 10));
    }

    public static List<Author> createAuthors() {
        List<Author> authors = new ArrayList<>();
        authors.add(createEntity("Marion Eleanor Zimmer", null, "Albany, New York, United States", new GregorianCalendar(1930, 6, 3)));
        authors.add(createEntity("Eleanor Marie Robertson", null, "Silver Spring, Maryland, U.S.A", new GregorianCalendar(1950, 9, 10)));
        return authors;
    }

    @Override
    protected void prepareDbData() {
    }

}
