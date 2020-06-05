package com.library.server;

import com.library.rest.api.RootResource;
import com.library.rest.api.service.AuthorRestService;
import com.library.rest.api.service.BookRestService;
import com.library.rest.api.service.PublisherRestService;
import com.library.rest.api.service.WorkFormRestService;
import com.library.rest.api.vo.YearVo;
import com.library.rest.api.vo.book.AuthorVo;
import com.library.rest.api.vo.book.BookSerieVo;
import com.library.rest.api.vo.book.BookStatesVo;
import com.library.rest.api.vo.book.BookStatusVo;
import com.library.rest.api.vo.book.BookVo;
import com.library.rest.api.vo.book.PublisherVo;
import com.library.rest.api.vo.book.WorkFormVo;
import com.library.rest.api.vo.list.AuthorsListVo;
import com.library.rest.api.vo.list.BooksListVo;
import com.library.rest.api.vo.list.PublishersListVo;
import com.library.rest.api.vo.list.WorkFormsListVo;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author gdimitrova
 */
public class IntegrationBookRestServiceTest
        extends IntegrationAbstractCrudRestServiceTest<BookVo, BooksListVo, BookRestService> {

    private static AuthorVo author;

    private static AuthorsListVo authors;

    private static PublisherVo publisher;

    private static PublishersListVo publishers;

    private static WorkFormVo workForm;

    private static WorkFormsListVo workForms;

    public IntegrationBookRestServiceTest() {
        super(BookVo.class, BooksListVo.class);
    }

    @Override
    protected BookVo createVo() {
        return createDefault();
    }

    @Override
    protected BookRestService getRestService() {
        return proxy.getBooksRestService();
    }

    @Override
    protected BooksListVo createListVo() {
        return createBooks();
    }

    @Override
    protected void assertVos(BookVo expected, BookVo actual, boolean isSaveAction) {
        assertBooks(expected, actual, isSaveAction);
    }

    @Override
    protected void prepareData() {
        prepareDB(proxy);
    }

    public static void assertBooks(BookVo expected, BookVo actual, boolean isSaveAction) {
        if (!isSaveAction) {
            assertEquals(expected, actual);
            return;
        }
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getSignature(), actual.getSignature());
        assertEquals(expected.getState(), actual.getState());
        assertEquals(expected.getStatus(), actual.getStatus());
        assertEquals(expected.getPublishYear(), actual.getPublishYear());
        assertEquals(expected.getPublisher(), actual.getPublisher());
        assertEquals(expected.getForm(), actual.getForm());
        assertEquals(expected.getAuthor(), actual.getAuthor());
        assertEquals(expected.getAuthor(), actual.getAuthor());
        assertEquals(expected.getSerie(), actual.getSerie());
        assertEquals(expected.getInventoryNumber(), actual.getInventoryNumber());
        assertEquals(expected.getisbn(), actual.getisbn());
    }

    public static void prepareDB(RootResource proxy) {
        AuthorRestService authorsRestService = proxy.getAuthorsRestService();
        PublisherRestService publishersRestService = proxy.getPublishersRestService();
        WorkFormRestService workformsRestService = proxy.getWorkformsRestService();
        
        Response rsp = authorsRestService.save(IntegrationAuthorRestServiceTest.createDefault());
        author = rsp.readEntity(AuthorVo.class);
        rsp.close();
        rsp = authorsRestService.saveAll(IntegrationAuthorRestServiceTest.createAuthors());
        rsp.close();
        rsp = authorsRestService.loadAll();
        authors = rsp.readEntity(AuthorsListVo.class);
        rsp.close();
        
        rsp = publishersRestService.save(IntegrationPublisherRestServiceTest.createDefault());
        publisher = rsp.readEntity(PublisherVo.class);
        rsp.close();
        rsp = publishersRestService.saveAll(IntegrationPublisherRestServiceTest.createPublishers());
        rsp.close();
        rsp = publishersRestService.loadAll();
        publishers = rsp.readEntity(PublishersListVo.class);
        rsp.close();
        
        rsp = workformsRestService.save(IntegrationWorkFormRestServiceTest.createDefault());
        workForm = rsp.readEntity(WorkFormVo.class);
        rsp.close();
        rsp = workformsRestService.saveAll(IntegrationWorkFormRestServiceTest.createWorkForms());
        rsp.close();
        rsp = workformsRestService.loadAll();
        workForms = rsp.readEntity(WorkFormsListVo.class);
        rsp.close();
    }

    private static BookVo createVo(String title, String signature, BookStatesVo state, BookStatusVo status,
            PublisherVo publisher, YearVo publishYear, WorkFormVo form, AuthorVo author,
            BookSerieVo serie, String inventoryNumber, String ISBN) {
        return new BookVo(title, signature, state, status, publisher, publishYear, form, author, serie, inventoryNumber, ISBN);
    }

    public static BookVo createDefault() {
        return createVo("The big hunt", "2020", BookStatesVo.NEW, BookStatusVo.AVAILABLE, publisher,
                new YearVo(2010), workForm, author, null, "2020001", "561-561-55-63");
    }

    public static BooksListVo createBooks() {
        List<BookVo> books = new ArrayList<>();
        books.add(createVo(
                "The big goal", "202", BookStatesVo.NEW, BookStatusVo.AVAILABLE,
                publishers.getEntities().get(0), new YearVo(2010),
                workForms.getEntities().get(0), authors.getEntities().get(0),
                null, "2020101", "561-561-45-63")
        );
        books.add(createVo(
                "The big purpose", "2011", BookStatesVo.NEW, BookStatusVo.AVAILABLE,
                publishers.getEntities().get(1), new YearVo(2010),
                workForms.getEntities().get(1), authors.getEntities().get(1),
                null, "2020101", "561-561-45-63")
        );
        return new BooksListVo(books);
    }

}
