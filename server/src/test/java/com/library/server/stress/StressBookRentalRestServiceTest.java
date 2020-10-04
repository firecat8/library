package com.library.server.stress;

import com.library.server.stress.book.StressBookRestServiceTest;
import com.library.rest.api.RootResource;
import com.library.rest.api.service.BookRentalRestService;
import com.library.rest.api.service.BookRestService;
import com.library.rest.api.service.UserRestService;
import com.library.rest.api.vo.DateVo;
import com.library.rest.api.vo.book.BookRentalVo;
import com.library.rest.api.vo.book.BookVo;
import com.library.rest.api.vo.list.BooksListVo;
import com.library.rest.api.vo.list.BooksRentalListVo;
import com.library.rest.api.vo.list.UsersListVo;
import com.library.rest.api.vo.user.UserVo;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ws.rs.core.Response;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author gdimitrova
 */
public class StressBookRentalRestServiceTest
        extends StressAbstractCrudRestServiceTest<BookRentalVo, BooksRentalListVo, BookRentalRestService> {

    private static BookVo book;

    private static BooksListVo books;

    private static UserVo user;

    private static UsersListVo users;

    public StressBookRentalRestServiceTest() {
        super(BookRentalVo.class, BooksRentalListVo.class);
    }

    @Override
    protected BookRentalVo createVo() {
        return createDefault();
    }

    @Override
    protected BookRentalRestService getRestService(RootResource proxy) {
        return proxy.getBooksRentalsRestService();
    }

    @Override
    protected BooksRentalListVo createListVo() {
        return createBookRentals();
    }

    @Override
    protected void assertVos(BookRentalVo expected, BookRentalVo actual, boolean isSaveAction) {
        if (!isSaveAction) {
            assertEquals(expected, actual);
            return;
        }
        StressBookRestServiceTest.assertBooks(expected.getBook(), actual.getBook(), isSaveAction);
        StressUserRestServiceTest.assertUsers(expected.getUser(), actual.getUser(), isSaveAction);
    }

    @Override
    protected void prepareData(RootResource proxy) {
        StressBookRestServiceTest.prepareDB(proxy);
        BookRestService booksRestService = proxy.getBooksRestService();
        UserRestService usersRestService = proxy.getUsersRestService();
        Response rsp = booksRestService.save(StressBookRestServiceTest.createDefault());
        book = rsp.readEntity(BookVo.class);
        rsp.close();
        rsp = booksRestService.saveAll(StressBookRestServiceTest.createBooks());
        rsp.close();
        rsp = booksRestService.loadAll();
        books = rsp.readEntity(BooksListVo.class);
        rsp.close();
        rsp = usersRestService.save(StressUserRestServiceTest.createDefault());
        user = rsp.readEntity(UserVo.class);
        rsp.close();
        rsp = usersRestService.saveAll(StressUserRestServiceTest.createUsers());
        rsp.close();
        rsp = usersRestService.loadAll();
        users = rsp.readEntity(UsersListVo.class);
        rsp.close();
    }

    public static BookRentalVo createDefault() {
        return createVo(
                book, user,
                new DateVo(new GregorianCalendar(2020, 4, 25)),
                new DateVo(new GregorianCalendar(2020, 5, 20)), null
        );
    }

    private static BookRentalVo createVo(BookVo book, UserVo user, DateVo receivableDate, DateVo returnDeadLine, DateVo returnDate) {
        return new BookRentalVo(book, user, receivableDate, returnDeadLine, returnDate);
    }

    public static BooksRentalListVo createBookRentals() {
        List<BookRentalVo> bookRentals = new ArrayList<>();
        bookRentals.add(createVo(
                books.getEntities().get(0),
                users.getEntities().get(0),
                new DateVo(new GregorianCalendar(2020, 5, 2)),
                new DateVo(new GregorianCalendar(2020, 5, 20)),
                new DateVo(new GregorianCalendar(2020, 5, 10))
        ));
        bookRentals.add(createVo(
                books.getEntities().get(1),
                users.getEntities().get(1),
                new DateVo(new GregorianCalendar(2020, 5, 2)),
                new DateVo(new GregorianCalendar(2020, 5, 20)), null
        ));
        return new BooksRentalListVo(bookRentals);
    }

}
