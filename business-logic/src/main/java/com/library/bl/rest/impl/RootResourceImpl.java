package com.library.bl.rest.impl;

import com.library.bl.rest.impl.user.UserRestServiceImpl;
import com.library.bl.rest.impl.vo.exchanger.AuthorVoExchanger;
import com.library.bl.rest.impl.vo.exchanger.BookRentalVoExchanger;
import com.library.bl.rest.impl.vo.exchanger.BookSerieVoExchanger;
import com.library.bl.rest.impl.vo.exchanger.BookVoExchanger;
import com.library.bl.rest.impl.vo.exchanger.CharacteristicVoExchanger;
import com.library.bl.rest.impl.vo.exchanger.GenreVoExchanger;
import com.library.bl.rest.impl.vo.exchanger.PublisherVoExchanger;
import com.library.bl.rest.impl.vo.exchanger.WorkFormVoExchanger;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.rest.api.CrudRestService;
import com.library.rest.api.RootResource;
import com.library.rest.api.user.UserRestService;
import com.library.rest.api.vo.book.AuthorVo;
import com.library.rest.api.vo.book.BookRentalVo;
import com.library.rest.api.vo.book.BookSerieVo;
import com.library.rest.api.vo.book.BookVo;
import com.library.rest.api.vo.book.CharacteristicVo;
import com.library.rest.api.vo.book.GenreVo;
import com.library.rest.api.vo.book.PublisherVo;
import com.library.rest.api.vo.book.WorkFormVo;
import com.library.rest.api.vo.list.AuthorsListVo;
import com.library.rest.api.vo.list.BookSeriesListVo;
import com.library.rest.api.vo.list.BooksListVo;
import com.library.rest.api.vo.list.BooksRentalListVo;
import com.library.rest.api.vo.list.CharacteristicsListVo;
import com.library.rest.api.vo.list.GenresListVo;
import com.library.rest.api.vo.list.PublishersListVo;
import com.library.rest.api.vo.list.WorkFormsListVo;

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
    public CrudRestService<BookVo, BooksListVo> getBooksRestService() {
        return new CrudRestServiceImpl<>(
                daoRegistryFactory,
                BookVoExchanger.INSTANCE,
                BooksListVo::new,
                DaoRegistry::getBookDao
        );
    }

    @Override
    public CrudRestService<AuthorVo, AuthorsListVo> getAuthorsRestService() {
        return new CrudRestServiceImpl<>(
                daoRegistryFactory,
                AuthorVoExchanger.INSTANCE,
                AuthorsListVo::new,
                DaoRegistry::getAuthorDao
        );
    }

    @Override
    public CrudRestService<BookRentalVo, BooksRentalListVo> getBooksRentalsRestService() {
        return new CrudRestServiceImpl<>(
                daoRegistryFactory,
                BookRentalVoExchanger.INSTANCE,
                BooksRentalListVo::new,
                DaoRegistry::getBookRentalDao
        );
    }

    @Override
    public CrudRestService<BookSerieVo, BookSeriesListVo> getBookSeriesRestService() {
        return new CrudRestServiceImpl<>(
                daoRegistryFactory,
                BookSerieVoExchanger.INSTANCE,
                BookSeriesListVo::new,
                DaoRegistry::getBookSerieDao
        );
    }

    @Override
    public CrudRestService<CharacteristicVo, CharacteristicsListVo> getCharacteristicsRestService() {
        return new CrudRestServiceImpl<>(
                daoRegistryFactory,
                CharacteristicVoExchanger.INSTANCE,
                CharacteristicsListVo::new,
                DaoRegistry::getCharacteristicDao
        );
    }

    @Override
    public CrudRestService<GenreVo, GenresListVo> getGenresRestService() {
        return new CrudRestServiceImpl<>(
                daoRegistryFactory,
                GenreVoExchanger.INSTANCE,
                GenresListVo::new,
                DaoRegistry::getGenreDao
        );
    }

    @Override
    public CrudRestService<PublisherVo, PublishersListVo> getPublishersRestService() {
        return new CrudRestServiceImpl<>(
                daoRegistryFactory,
                PublisherVoExchanger.INSTANCE,
                PublishersListVo::new,
                DaoRegistry::getPublisherDao
        );
    }

    @Override
    public CrudRestService<WorkFormVo, WorkFormsListVo> getWorkformsRestService() {
        return new CrudRestServiceImpl<>(
                daoRegistryFactory,
                WorkFormVoExchanger.INSTANCE,
                WorkFormsListVo::new,
                DaoRegistry::getWorkFormDao
        );
    }

}
