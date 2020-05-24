/*
 * Project library
 */
package com.library.persistence;

import com.library.dao.book.WorkFormDaoImpl;
import com.library.domain.WorkForm;
import com.library.dto.WorkFormDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class WorkFormDaoTestCase extends AbstractCrudDaoTestCase<WorkFormDto, WorkForm, WorkFormDaoImpl> {

    @Override
    protected WorkForm createEntity() {
        return createEntity("Novel");
    }

    @Override
    protected List<WorkForm> createEntities() {
        return createWorkForms();
    }

    @Override
    protected WorkFormDaoImpl getTestDao() {
        return (WorkFormDaoImpl) registry.getWorkFormDao();
    }

    private static WorkForm createEntity(String name) {
        return new WorkForm(name);
    }

    public static List<WorkForm> createWorkForms() {
        List<WorkForm> workForms = new ArrayList<>();
        workForms.add(createEntity("Biography"));
        workForms.add(createEntity("Poem"));
        return workForms;
    }

    @Override
    protected void prepareDbData() {
    }
}
