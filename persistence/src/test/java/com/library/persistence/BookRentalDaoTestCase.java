/*
 * Project library
 */
package com.library.persistence;

import com.library.dao.BookDao;
import com.library.dao.DaoRegistry;
import com.library.dao.UserDao;
import com.library.dao.book.BookRentalDaoImpl;
import com.library.domain.book.Book;
import com.library.domain.book.BookRental;
import com.library.domain.user.User;
import com.library.dto.BookRentalDto;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class BookRentalDaoTestCase extends AbstractCrudDaoTestCase<BookRentalDto, BookRental, BookRentalDaoImpl> {
    
    private static Book book;
    
    private static List<Book> books;
    
    private static User user;
    
    private static List<User> users;
    
    @Override
    protected BookRentalDaoImpl getDao(DaoRegistry registry) {
        return (BookRentalDaoImpl) registry.getBookRentalDao();
    }
    
    @Override
    protected BookRental createEntity() {
        return createEntity(book, user,
                new GregorianCalendar(2020, 4, 25), new GregorianCalendar(2020, 5, 20), null
        );
    }
    
    @Override
    protected List<BookRental> createEntities() {
        return createBookRentals();
    }
    
    private static BookRental createEntity(Book book, User user, Calendar receivableDate, Calendar returnDeadLine, Calendar returnDate) {
        return new BookRental(book, user, receivableDate, returnDeadLine, returnDate);
    }
    
    public static List<BookRental> createBookRentals() {
        List<BookRental> bookRentals = new ArrayList<>();
        bookRentals.add(createEntity(books.get(0), users.get(0),
                new GregorianCalendar(2020, 5, 2), new GregorianCalendar(2020, 5, 20), new GregorianCalendar(2020, 5, 10)
        ));
        bookRentals.add(createEntity(books.get(1), users.get(1),
                new GregorianCalendar(2020, 5, 2), new GregorianCalendar(2020, 5, 20), null
        ));
        return bookRentals;
    }
    
    @Override
    protected boolean isRequiredDbDataPreparation() {
        return true;
    }
    
    @Override
    protected void prepareDbData(DaoRegistry registry) {
        BookDaoTestCase.prepareDB(registry);
        BookDao bookDao = registry.getBookDao();
        UserDao userDao = registry.getUserDao();
        book = bookDao.save(BookDaoTestCase.createDefault());
        books = bookDao.saveAll(BookDaoTestCase.createBooks());
        user = userDao.save(UserDaoTestCase.createDefault());
        users = userDao.saveAll(UserDaoTestCase.createUsers());
    }
    
}
