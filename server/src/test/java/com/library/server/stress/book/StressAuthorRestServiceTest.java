package com.library.server.stress.book;

import com.library.rest.api.RootResource;
import com.library.rest.api.service.AuthorRestService;
import com.library.rest.api.vo.DateVo;
import com.library.rest.api.vo.book.AuthorVo;
import com.library.rest.api.vo.list.AuthorsListVo;
import com.library.server.stress.StressAbstractCrudRestServiceTest;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author gdimitrova
 */
public class StressAuthorRestServiceTest
        extends StressAbstractCrudRestServiceTest<AuthorVo, AuthorsListVo, AuthorRestService> {

    public StressAuthorRestServiceTest() {
        super(AuthorVo.class, AuthorsListVo.class);
    }

    @Override
    protected AuthorVo createVo() {
        return createDefault();
    }

    @Override
    protected AuthorRestService getRestService(RootResource proxy) {
        return proxy.getAuthorsRestService();
    }

    @Override
    protected AuthorsListVo createListVo() {
        return createAuthors();
    }

    @Override
    protected void assertVos(AuthorVo expected, AuthorVo actual, boolean isSaveAction) {
        if (!isSaveAction) {
            assertEquals(expected, actual);
            return;
        }
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getBiography(), actual.getBiography());
        assertEquals(expected.getBirthPlace(), actual.getBirthPlace());
        assertEquals(expected.getBirthDate(), actual.getBirthDate());
    }

    @Override
    protected void prepareData(RootResource proxy) {
    }

    private static AuthorVo createVo(String name, String biography, String birthPlace, DateVo birthDate) {
        return new AuthorVo(name, biography, birthPlace, birthDate);
    }

    public static AuthorVo createDefault() {
        return createVo("Laurann Dohner", null, "Southern California, USA", new DateVo(new GregorianCalendar(1970, 5, 10)));
    }

    public static AuthorsListVo createAuthors() {
        List<AuthorVo> authors = new ArrayList<>();
        authors.add(createVo("Marion Eleanor Zimmer", null, "Albany, New York, United States",
                new DateVo(new GregorianCalendar(1930, 6, 3))));
        authors.add(createVo("Eleanor Marie Robertson", null, "Silver Spring, Maryland, U.S.A",
                new DateVo(new GregorianCalendar(1950, 9, 10))));
        return new AuthorsListVo(authors);
    }
}
