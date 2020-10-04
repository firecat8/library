package com.library.server.integration;

import com.library.rest.api.service.PublisherRestService;
import com.library.rest.api.vo.book.PublisherVo;
import com.library.rest.api.vo.list.PublishersListVo;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author gdimitrova
 */
public class IntegrationPublisherRestServiceTest
        extends IntegrationAbstractCrudRestServiceTest<PublisherVo, PublishersListVo, PublisherRestService> {

    public IntegrationPublisherRestServiceTest() {
        super(PublisherVo.class, PublishersListVo.class);
    }

    @Override
    protected PublisherVo createVo() {
        return createDefault();
    }

    @Override
    protected PublisherRestService getRestService() {
        return proxy.getPublishersRestService();
    }

    @Override
    protected PublishersListVo createListVo() {
        return createPublishers();
    }

    @Override
    protected void assertVos(PublisherVo expected, PublisherVo actual, boolean isSaveAction) {
        if (!isSaveAction) {
            assertEquals(expected, actual);
            return;
        }
        assertEquals(expected.getName(), actual.getName());
    }

    @Override
    protected void prepareData() {
    }

    private static PublisherVo createVo(String name) {
        return new PublisherVo(name);
    }

    public static PublisherVo createDefault() {
        return createVo("Novel");
    }

    public static PublishersListVo createPublishers() {
        List<PublisherVo> workForms = new ArrayList<>();
        workForms.add(createVo("Biography"));
        workForms.add(createVo("Poem"));
        return new PublishersListVo(workForms);
    }

}
