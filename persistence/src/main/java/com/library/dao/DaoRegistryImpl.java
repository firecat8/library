package com.library.dao;

import com.library.dao.book.AuthorDaoImpl;
import com.library.dao.book.BookDaoImpl;
import com.library.dao.book.BookSerieDaoImpl;
import com.library.dao.book.CharacteristicDaoImpl;
import com.library.dao.book.GenreDaoImpl;
import com.library.dao.book.PublisherDaoImpl;
import com.library.dao.book.WorkFormDaoImpl;
import javax.persistence.EntityManager;

/**
 *
 * @author gdimitrova
 */
public class DaoRegistryImpl implements DaoRegistry {

    private final EntityManager em;

    private final BookDao bookDao;

    private final UserDao userDao;

    private final BookSerieDao bookSerieDao;

    private final CharacteristicDao characteristicDao;

    private final GenreDao genreDao;

    private final AuthorDao authorDao;

    private final WorkFormDao workFormDao;

    private final PublisherDao publisherDao;

    public DaoRegistryImpl(EntityManager em) {
        this.em = em;
        bookDao = new BookDaoImpl(em);
        userDao = new UserDaoImpl(em);
        bookSerieDao = new BookSerieDaoImpl(em);
        characteristicDao = new CharacteristicDaoImpl(em);
        genreDao = new GenreDaoImpl(em);
        authorDao = new AuthorDaoImpl(em);
        workFormDao = new WorkFormDaoImpl(em);
        publisherDao = new PublisherDaoImpl(em);
    }

    @Override
    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public BookDao getBookDao() {
        return bookDao;
    }

    @Override
    public BookSerieDao getBookSerieDao() {
        return bookSerieDao;
    }

    @Override
    public CharacteristicDao getCharacteristicDao() {
        return characteristicDao;
    }

    @Override
    public GenreDao getGenreDao() {
        return genreDao;
    }

    @Override
    public AuthorDao getAuthorDao() {
        return authorDao;
    }

    @Override
    public WorkFormDao getWorkFormDao() {
        return workFormDao;
    }

    @Override
    public PublisherDao getPublisherDao() {
        return publisherDao;
    }

    @Override
    public void beginTransaction() {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
    }

    @Override
    public void rollbackTransaction() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void commitTransaction() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

    @Override
    public void close() throws Exception {
        em.close();
    }
}
