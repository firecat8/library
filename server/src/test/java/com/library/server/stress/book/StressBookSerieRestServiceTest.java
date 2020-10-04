package com.library.server.stress.book;

import com.library.rest.api.RootResource;
import com.library.rest.api.service.BookSerieRestService;
import com.library.rest.api.vo.book.BookSerieVo;
import com.library.rest.api.vo.list.BookSeriesListVo;
import com.library.server.stress.StressAbstractCrudRestServiceTest;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author gdimitrova
 */
public class StressBookSerieRestServiceTest
        extends StressAbstractCrudRestServiceTest<BookSerieVo, BookSeriesListVo, BookSerieRestService> {

    public StressBookSerieRestServiceTest() {
        super(BookSerieVo.class, BookSeriesListVo.class);
    }

    @Override
    protected BookSerieVo createVo() {
        return createDefault();
    }

    @Override
    protected BookSerieRestService getRestService(RootResource proxy) {
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
    protected void prepareData(RootResource proxy) {
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
