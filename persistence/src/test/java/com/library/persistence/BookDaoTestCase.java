/*
 * Project library
 */
package com.library.persistence;

import com.library.dao.DaoRegistry;
import com.library.dao.book.BookDaoImpl;
import com.library.domain.WorkForm;
import com.library.domain.book.Author;
import com.library.domain.book.Book;
import com.library.domain.book.BookSerie;
import com.library.domain.book.BookStates;
import com.library.domain.book.Publisher;
import com.library.domain.user.Roles;
import com.library.domain.user.User;
import com.library.dto.BookDto;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class BookDaoTestCase extends AbstractCrudDaoTestCase<BookDto, Book, BookDaoImpl> {

    @Override
    protected BookDaoImpl getDao(DaoRegistry registry) {
        return (BookDaoImpl) registry.getBookDao();
    }

    @Override
    protected Book createEntity() {
       // return createEntity(title, signature, BookStates.NEW, publisher, 2020, form, author, null,"2020001", "561-561-55-63");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<Book> createEntities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static Book createEntity(String title, String signature, BookStates state, Publisher publisher, Year publishYear, WorkForm form, Author author, BookSerie serie, String inventoryNumber, String ISBN) {
        return new Book(title, signature, state, publisher, publishYear, form, author, serie, inventoryNumber, ISBN);
    }

    public static List<User> createUsers() {
        List<User> users = new ArrayList<>();
       // users.add(createEntity("admin", Roles.ADMINISTRATOR, "89645"));
     //   users.add(createEntity("ann", Roles.OPERATOR, "963158"));
        return users;
    }

    @Override
    protected void prepareDbData() {
//        try (DaoRegistry daoRegistry = dbEnvironment.makeDaoRegistry()) {
//            daoRegistry.beginTransaction();
//            getDao(daoRegistry).save(createEntity());
//            daoRegistry.commitTransaction();
//        }
    }
}
