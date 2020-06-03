package com.library.rest.api;

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
import javax.ws.rs.Path;

/**
 *
 * @author gdimitrova
 */
@Path("/")
public interface RootResource {

    @Path("/user")
    UserRestService getUsersRestService();

    @Path("/book")
    CrudRestService<BookVo, BooksListVo> getBooksRestService();

    @Path("/author")
    CrudRestService<AuthorVo, AuthorsListVo> getAuthorsRestService();

    @Path("/book/rental")
    CrudRestService<BookRentalVo, BooksRentalListVo> getBooksRentalsRestService();

    @Path("/book/serie")
    CrudRestService<BookSerieVo, BookSeriesListVo> getBookSeriesRestService();

    @Path("/characteristic")
    CrudRestService<CharacteristicVo, CharacteristicsListVo> getCharacteristicsRestService();

    @Path("/genre")
    CrudRestService<GenreVo, GenresListVo> getGenresRestService();

    @Path("/publisher")
    CrudRestService<PublisherVo, PublishersListVo> getPublishersRestService();

    @Path("/workForm")
    CrudRestService<WorkFormVo, WorkFormsListVo> getWorkformsRestService();

}
