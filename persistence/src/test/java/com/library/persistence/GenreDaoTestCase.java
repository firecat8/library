package com.library.persistence;

import com.library.dao.DaoRegistry;
import com.library.dao.book.GenreDaoImpl;
import com.library.domain.Genre;
import com.library.dto.GenreDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class GenreDaoTestCase extends AbstractCrudDaoTestCase<GenreDto, Genre, GenreDaoImpl> {

    @Override
    protected Genre createEntity() {
        return createEntity("Journal");
    }

    @Override
    protected List<Genre> createEntities() {
        return createGenres();
    }

    @Override
    protected GenreDaoImpl  getDao(DaoRegistry registry) {
        return (GenreDaoImpl) registry.getGenreDao();
    }

    private static Genre createEntity(String name) {
        return new Genre(name);
    }

    public static List<Genre> createGenres() {
        List<Genre> genres = new ArrayList<>();
        genres.add(createEntity("Prose"));
        genres.add(createEntity("Memoir"));
        return genres;
    }


}
