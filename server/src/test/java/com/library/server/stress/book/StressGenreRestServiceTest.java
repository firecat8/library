package com.library.server.stress.book;

import com.library.rest.api.RootResource;
import com.library.rest.api.service.GenreRestService;
import com.library.rest.api.vo.book.GenreVo;
import com.library.rest.api.vo.list.GenresListVo;
import com.library.server.stress.StressAbstractCrudRestServiceTest;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author gdimitrova
 */
public class StressGenreRestServiceTest
        extends StressAbstractCrudRestServiceTest<GenreVo, GenresListVo, GenreRestService> {

    public StressGenreRestServiceTest() {
        super(GenreVo.class, GenresListVo.class);
    }

    @Override
    protected GenreVo createVo() {
        return createDefault();
    }

    @Override
    protected GenreRestService getRestService(RootResource proxy) {
        return proxy.getGenresRestService();
    }

    @Override
    protected GenresListVo createListVo() {
        return createGenres();
    }

    @Override
    protected void assertVos(GenreVo expected, GenreVo actual, boolean isSaveAction) {
        if (!isSaveAction) {
            assertEquals(expected, actual);
            return;
        }
        assertEquals(expected.getName(), actual.getName());
    }

    @Override
    protected void prepareData(RootResource proxy) {
    }

    private static GenreVo createVo(String name) {
        return new GenreVo(name);
    }

    public static GenreVo createDefault() {
        return createVo("Novel");
    }

    public static GenresListVo createGenres() {
        List<GenreVo> workForms = new ArrayList<>();
        workForms.add(createVo("Biography"));
        workForms.add(createVo("Poem"));
        return new GenresListVo(workForms);
    }

}
