/*
 * Project library
 */
package com.library.persistence;

import com.library.dao.AuthorDao;
import com.library.dao.DaoRegistry;
import com.library.dao.PublisherDao;
import com.library.dao.WorkFormDao;
import com.library.dao.book.BookDaoImpl;
import com.library.domain.book.WorkForm;
import com.library.domain.book.Author;
import com.library.domain.book.Book;
import com.library.domain.book.BookSerie;
import com.library.domain.book.BookStates;
import com.library.domain.book.BookStatus;
import com.library.domain.book.Publisher;
import com.library.dto.BookDto;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class BookDaoTestCase extends AbstractCrudDaoTestCase<BookDto, Book, BookDaoImpl> {

    private static Author author;

    private static List<Author> authors;

    private static Publisher publisher;

    private static List<Publisher> publishers;

    private static WorkForm workForm;

    private static List<WorkForm> workForms;

    @Override
    protected BookDaoImpl getDao(DaoRegistry registry) {
        return (BookDaoImpl) registry.getBookDao();
    }

    @Override
    protected Book createEntity() {
        return createDefault();
    }

    @Override
    protected List<Book> createEntities() {
        return createBooks();
    }

    private static Book createEntity(String title, String signature, BookStates state, BookStatus status, Publisher publisher, Year publishYear, WorkForm form, Author author, BookSerie serie, String inventoryNumber, String ISBN) {
        return new Book(title, signature, state, status, publisher, publishYear, form, author, serie, inventoryNumber, ISBN);
    }

    public static Book createDefault() {
        return createEntity("The big hunt", "2020", BookStates.NEW, BookStatus.AVAILABLE, publisher, Year.parse("2010"), workForm, author, null, "2020001", "561-561-55-63");
    }

    public static List<Book> createBooks() {
        List<Book> books = new ArrayList<>();
        books.add(createEntity(
                "The big goal", "202", BookStates.NEW, BookStatus.AVAILABLE, publishers.get(0), Year.parse("2010"), workForms.get(0), authors.get(0), null, "2020101", "561-561-45-63")
        );
        books.add(createEntity(
                "The big purpose", "2011", BookStates.NEW, BookStatus.AVAILABLE, publishers.get(1), Year.parse("2010"), workForms.get(1), authors.get(1), null, "2020101", "561-561-45-63")
        );
        return books;
    }
    public static void prepareDB(DaoRegistry registry) {
        AuthorDao authorDao = registry.getAuthorDao();
        PublisherDao publisherDao = registry.getPublisherDao();
        WorkFormDao workFormDao = registry.getWorkFormDao();
        author = authorDao.save(AuthorDaoTestCase.createDefault());
        authors = authorDao.saveAll(AuthorDaoTestCase.createAuthors());
        publisher = publisherDao.save(PublisherDaoTestCase.createDefault());
        publishers = publisherDao.saveAll(PublisherDaoTestCase.createPublishers());
        workForm = workFormDao.save(WorkFormDaoTestCase.createDefault());
        workForms = workFormDao.saveAll(WorkFormDaoTestCase.createWorkForms());
        
    }

    @Override
    protected void prepareDbData(DaoRegistry registry) {
        prepareDB(registry);
    }

    @Override
    protected boolean isRequiredDbDataPreparation() {
        return true;
    }
}
