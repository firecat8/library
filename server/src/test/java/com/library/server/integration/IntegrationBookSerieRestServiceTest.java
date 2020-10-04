package com.library.server.integration;

import com.library.rest.api.service.BookSerieRestService;
import com.library.rest.api.vo.book.BookSerieVo;
import com.library.rest.api.vo.list.BookSeriesListVo;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author gdimitrova
 */
public class IntegrationBookSerieRestServiceTest
        extends IntegrationAbstractCrudRestServiceTest<BookSerieVo, BookSeriesListVo, BookSerieRestService> {

    public IntegrationBookSerieRestServiceTest() {
        super(BookSerieVo.class, BookSeriesListVo.class);
    }

    @Override
    protected BookSerieVo createVo() {
        return createDefault();
    }

    @Override
    protected BookSerieRestService getRestService() {
        return proxy.getBookSeriesRestService();
    }

    @Override
    protected BookSeriesListVo createListVo() {
        return createBookSeries();
    }

    @Override
    protected void assertVos(BookSerieVo expected, BookSerieVo actual, boolean isSaveAction) {
        if (!isSaveAction) {
            assertEquals(expected, actual);
            return;
        }
        assertEquals(expected.getName(), actual.getName());
    }

    @Override
    protected void prepareData() {
    }

    private static BookSerieVo createVo(String name) {
        return new BookSerieVo(name);
    }

    public static BookSerieVo createDefault() {
        return createVo("Novel");
    }

    public static BookSeriesListVo createBookSeries() {
        List<BookSerieVo> workForms = new ArrayList<>();
        workForms.add(createVo("Biography"));
        workForms.add(createVo("Poem"));
        return new BookSeriesListVo(workForms);
    }

}
