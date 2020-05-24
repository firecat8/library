/*
 * Project library
 */
package com.library.persistence;

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
        return createEntity("Big 5");
    }

    @Override
    protected List<Publisher> createEntities() {
        return createPublishers();
    }

    @Override
    protected PublisherDaoImpl getTestDao() {
        return (PublisherDaoImpl) registry.getPublisherDao();
    }

    private static Publisher createEntity(String name) {
        return new Publisher(name);
    }

    public static List<Publisher> createPublishers() {
        List<Publisher> publishers = new ArrayList<>();
        publishers.add(createEntity("Macmillan Publishers"));
        publishers.add(createEntity("Simon & Schuster"));
        return publishers;
    }

    @Override
    protected void prepareDbData() {
    }
    
}