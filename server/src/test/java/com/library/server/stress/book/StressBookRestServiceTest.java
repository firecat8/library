package com.library.server.stress.book;

import com.library.rest.api.RootResource;
import com.library.rest.api.service.AuthorRestService;
import com.library.rest.api.service.BookRestService;
import com.library.rest.api.service.FormatSignatureRestService;
import com.library.rest.api.service.PublisherRestService;
import com.library.rest.api.service.StockSignatureRestService;
import com.library.rest.api.service.WorkFormRestService;
import com.library.rest.api.vo.YearVo;
import com.library.rest.api.vo.book.AuthorVo;
import com.library.rest.api.vo.book.BookSerieVo;
import com.library.rest.api.vo.book.BookStatesVo;
import com.library.rest.api.vo.book.BookStatusVo;
import com.library.rest.api.vo.book.BookVo;
import com.library.rest.api.vo.book.PublisherVo;
import com.library.rest.api.vo.book.WorkFormVo;
import com.library.rest.api.vo.book.signature.FormatSignatureVo;
import com.library.rest.api.vo.book.signature.StockSignatureVo;
import com.library.rest.api.vo.list.AuthorsListVo;
import com.library.rest.api.vo.list.BooksListVo;
import com.library.rest.api.vo.list.FormatSignaturesListVo;
import com.library.rest.api.vo.list.PublishersListVo;
import com.library.rest.api.vo.list.StockSignaturesListVo;
import com.library.rest.api.vo.list.WorkFormsListVo;
import com.library.server.stress.StressAbstractCrudRestServiceTest;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author gdimitrova
 */
public class StressBookRestServiceTest
        extends StressAbstractCrudRestServiceTest<BookVo, BooksListVo, BookRestService> {

    private static AuthorVo author;

    private static AuthorsListVo authors;

    private static PublisherVo publisher;

    private static PublishersListVo publishers;

    private static WorkFormVo workForm;

    private static WorkFormsListVo workForms;

    private static FormatSignatureVo formatSignature;

    private static FormatSignaturesListVo formatSignatures;

    private static StockSignatureVo stockSignature;

    private static StockSignaturesListVo stockSignatures;

    public StressBookRestServiceTest() {
        super(BookVo.class, BooksListVo.class);
    }

    @Override
    protected BookVo createVo() {
        return createDefault();
    }

    @Override
    protected BookRestService getRestService(RootResource proxy) {
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
    protected void prepareData(RootResource proxy) {
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
        StockSignatureRestService stockSignaturesRestService = proxy.getStockSignaturesRestService();
        FormatSignatureRestService formatSignaturesRestService = proxy.getFormatSignaturesRestService();

        Response rsp = authorsRestService.save(StressAuthorRestServiceTest.createDefault());
        author = rsp.readEntity(AuthorVo.class);
        rsp.close();
        rsp = authorsRestService.saveAll(StressAuthorRestServiceTest.createAuthors());
        rsp.close();
        rsp = authorsRestService.loadAll();
        authors = rsp.readEntity(AuthorsListVo.class);
        rsp.close();

        rsp = publishersRestService.save(StressPublisherRestServiceTest.createDefault());
        publisher = rsp.readEntity(PublisherVo.class);
        rsp.close();
        rsp = publishersRestService.saveAll(StressPublisherRestServiceTest.createPublishers());
        rsp.close();
        rsp = publishersRestService.loadAll();
        publishers = rsp.readEntity(PublishersListVo.class);
        rsp.close();

        rsp = workformsRestService.save(StressWorkFormRestServiceTest.createDefault());
        workForm = rsp.readEntity(WorkFormVo.class);
        rsp.close();
        rsp = workformsRestService.saveAll(StressWorkFormRestServiceTest.createWorkForms());
        rsp.close();
        rsp = workformsRestService.loadAll();
        workForms = rsp.readEntity(WorkFormsListVo.class);
        rsp.close();

        rsp = stockSignaturesRestService.save(StressStockSignatureRestServiceTest.createDefault());
        stockSignature = rsp.readEntity(StockSignatureVo.class);
        rsp.close();
        rsp = stockSignaturesRestService.saveAll(StressStockSignatureRestServiceTest.createStockSignatures());
        rsp.close();
        rsp = stockSignaturesRestService.loadAll();
        stockSignatures = rsp.readEntity(StockSignaturesListVo.class);
        rsp.close();

        rsp = formatSignaturesRestService.save(StressFormatSignatureRestServiceTest.createDefault());
        formatSignature = rsp.readEntity(FormatSignatureVo.class);
        rsp.close();
        rsp = formatSignaturesRestService.saveAll(StressFormatSignatureRestServiceTest.createFormatSignatures());
        rsp.close();
        rsp = formatSignaturesRestService.loadAll();
        formatSignatures = rsp.readEntity(FormatSignaturesListVo.class);
        rsp.close();
    }

    private static BookVo createVo(String title, FormatSignatureVo formatSignature, StockSignatureVo stockSignature, String signature, BookStatesVo state, BookStatusVo status,
            PublisherVo publisher, YearVo publishYear, WorkFormVo form, AuthorVo author,
            BookSerieVo serie, String inventoryNumber, String ISBN) {
        return new BookVo(title, formatSignature, stockSignature, signature, state, status, publisher, publishYear, form, author, serie, inventoryNumber, ISBN);
    }

    public static BookVo createDefault() {
        return createVo("The big hunt", formatSignature, stockSignature, "2020", BookStatesVo.NEW, BookStatusVo.AVAILABLE, publisher,
                new YearVo(2010), workForm, author, null, "2020001", "561-561-55-63");
    }

    public static BooksListVo createBooks() {
        List<BookVo> books = new ArrayList<>();
        books.add(createVo(
                "The big goal", formatSignatures.getEntities().get(0), stockSignatures.getEntities().get(0),
                "202", BookStatesVo.NEW, BookStatusVo.AVAILABLE,
                publishers.getEntities().get(0), new YearVo(2010),
                workForms.getEntities().get(0), authors.getEntities().get(0),
                null, "2020101", "561-561-45-63")
        );
        books.add(createVo(
                "The big purpose", formatSignatures.getEntities().get(1), stockSignatures.getEntities().get(1),
                "2011", BookStatesVo.NEW, BookStatusVo.AVAILABLE,
                publishers.getEntities().get(1), new YearVo(2010),
                workForms.getEntities().get(1), authors.getEntities().get(1),
                null, "2020101", "561-561-45-63")
        );
        return new BooksListVo(books);
    }

}
