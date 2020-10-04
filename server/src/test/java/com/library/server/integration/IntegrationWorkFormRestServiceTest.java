package com.library.server.integration;

import com.library.rest.api.service.WorkFormRestService;
import com.library.rest.api.vo.book.WorkFormVo;
import com.library.rest.api.vo.list.WorkFormsListVo;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author gdimitrova
 */
public class IntegrationWorkFormRestServiceTest
        extends IntegrationAbstractCrudRestServiceTest<WorkFormVo, WorkFormsListVo, WorkFormRestService> {

    public IntegrationWorkFormRestServiceTest() {
        super(WorkFormVo.class, WorkFormsListVo.class);
    }

    @Override
    protected WorkFormVo createVo() {
        return createDefault();
    }

    @Override
    protected WorkFormRestService getRestService() {
        return proxy.getWorkformsRestService();
    }

    @Override
    protected WorkFormsListVo createListVo() {
        return createWorkForms();
    }

    @Override
    protected void assertVos(WorkFormVo expected, WorkFormVo actual, boolean isSaveAction) {
        if (!isSaveAction) {
            assertEquals(expected, actual);
            return;
        }
        assertEquals(expected.getName(), actual.getName());
    }

    @Override
    protected void prepareData() {
    }

    private static WorkFormVo createVo(String name) {
        return new WorkFormVo(name);
    }

    public static WorkFormVo createDefault() {
        return createVo("Novel");
    }

    public static WorkFormsListVo createWorkForms() {
        List<WorkFormVo> workForms = new ArrayList<>();
        workForms.add(createVo("Biography"));
        workForms.add(createVo("Poem"));
        return new WorkFormsListVo(workForms);
    }

}
