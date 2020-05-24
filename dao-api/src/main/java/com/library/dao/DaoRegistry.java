package com.library.dao;

/**
 *
 * @author gdimitrova
 */
public interface DaoRegistry {

    public UserDao getUserDao();

    public BookDao getBookDao();

    public BookSerieDao getBookSerieDao();

    public CharacteristicDao getCharacteristicDao();

    public GenreDao getGenreDao();

    public AuthorDao getAuthorDao();

    public WorkFormDao getWorkFormDao();

    public PublisherDao getPublisherDao();

    public void beginTransaction();

    public void rollbackTransaction();

    public void commitTransaction();
}
