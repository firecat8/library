package com.library.bl.rest.impl;

import com.library.bl.rest.impl.service.AuthorRestServiceImpl;
import com.library.bl.rest.impl.service.BookRentalRestServiceImpl;
import com.library.bl.rest.impl.service.BookRestServiceImpl;
import com.library.bl.rest.impl.service.BookSerieRestServiceImpl;
import com.library.bl.rest.impl.service.CharacteristicRestServiceImpl;
import com.library.bl.rest.impl.service.GenreRestServiceImpl;
import com.library.bl.rest.impl.service.PublisherRestServiceImpl;
import com.library.bl.rest.impl.service.UserRestServiceImpl;
import com.library.bl.rest.impl.service.WorkFormRestServiceImpl;
import com.library.dao.DaoRegistryFactory;
import com.library.rest.api.RootResource;
import com.library.rest.api.service.AuthorRestService;
import com.library.rest.api.service.BookRentalRestService;
import com.library.rest.api.service.BookRestService;
import com.library.rest.api.service.BookSerieRestService;
import com.library.rest.api.service.CharacteristicRestService;
import com.library.rest.api.service.GenreRestService;
import com.library.rest.api.service.PublisherRestService;
import com.library.rest.api.service.UserRestService;
import com.library.rest.api.service.WorkFormRestService;

/**
 *
 * @author gdimitrova
 */
public class RootResourceImpl implements RootResource {

    private final DaoRegistryFactory daoRegistryFactory;

    public RootResourceImpl(DaoRegistryFactory daoRegistryFactory) {
        this.daoRegistryFactory = daoRegistryFactory;
    }

    @Override
    public UserRestService getUsersRestService() {
         return new UserRestServiceImpl(daoRegistryFactory);
    }

    @Override
    public BookRestService getBooksRestService() {
         return new BookRestServiceImpl(daoRegistryFactory);
    }

    @Override
    public AuthorRestService getAuthorsRestService() {
         return new AuthorRestServiceImpl(daoRegistryFactory);
    }

    @Override
    public BookRentalRestService getBooksRentalsRestService() {
         return new BookRentalRestServiceImpl(daoRegistryFactory);
    }

    @Override
    public BookSerieRestService getBookSeriesRestService() {
         return new BookSerieRestServiceImpl(daoRegistryFactory);
    }

    @Override
    public CharacteristicRestService getCharacteristicsRestService() {
         return new CharacteristicRestServiceImpl(daoRegistryFactory);
    }

    @Override
    public PublisherRestService getPublishersRestService() {
        return new PublisherRestServiceImpl(daoRegistryFactory);
    }

    @Override
    public GenreRestService getGenresRestService() {
        return new GenreRestServiceImpl(daoRegistryFactory);
    }
    
    @Override
    public WorkFormRestService getWorkformsRestService() {
        return new WorkFormRestServiceImpl(daoRegistryFactory);
    }

}
