/*
 * Project library
 */
package com.library.persistence;

import com.library.dao.DaoRegistry;
import com.library.dao.book.PublisherDaoImpl;
import com.library.domain.book.Publisher;
import com.library.dto.PublisherDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class PublisherDaoTestCase extends AbstractCrudDaoTestCase<PublisherDto, Publisher, PublisherDaoImpl> {

    @Override
    protected Publisher createEntity() {
        return createDefault();
    }

    @Override
    protected List<Publisher> createEntities() {
        return createPublishers();
    }

    @Override
    protected PublisherDaoImpl getDao(DaoRegistry registry) {
        return (PublisherDaoImpl) registry.getPublisherDao();
    }

    private static Publisher createEntity(String name) {
        return new Publisher(name);
    }

    public static Publisher createDefault() {
        return createEntity("Big 5");
    }

    public static List<Publisher> createPublishers() {
        List<Publisher> publishers = new ArrayList<>();
        publishers.add(createEntity("Macmillan Publishers"));
        publishers.add(createEntity("Simon & Schuster"));
        return publishers;
    }

    @Override
    protected void prepareDbData(DaoRegistry registry) {
    }

    @Override
    protected boolean isRequiredDbDataPreparation() {
        return false;
    }
}
