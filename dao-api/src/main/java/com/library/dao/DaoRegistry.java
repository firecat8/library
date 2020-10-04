package com.library.dao;

/**
 *
 * @author gdimitrova
 */
public interface DaoRegistry extends AutoCloseable {

    public UserDao getUserDao();

    public BookDao getBookDao();

    public BookSerieDao getBookSerieDao();

    public BookRentalDao getBookRentalDao();

    public CharacteristicDao getCharacteristicDao();

    public GenreDao getGenreDao();

    public AuthorDao getAuthorDao();

    public WorkFormDao getWorkFormDao();

    public PublisherDao getPublisherDao();

    public StockSignatureDao getStockSignatureDao();

    public FormatSignatureDao getFormatSignatureDao();

    public void beginTransaction();

    public void rollbackTransaction();

    public void commitTransaction();
}
