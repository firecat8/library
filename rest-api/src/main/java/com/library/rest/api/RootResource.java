package com.library.rest.api;

import com.library.rest.api.service.AuthorRestService;
import com.library.rest.api.service.BookRentalRestService;
import com.library.rest.api.service.BookRestService;
import com.library.rest.api.service.BookSerieRestService;
import com.library.rest.api.service.CharacteristicRestService;
import com.library.rest.api.service.FormatSignatureRestService;
import com.library.rest.api.service.GenreRestService;
import com.library.rest.api.service.PublisherRestService;
import com.library.rest.api.service.StockSignatureRestService;
import com.library.rest.api.service.UserRestService;
import com.library.rest.api.service.WorkFormRestService;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author gdimitrova
 */
@Path("/")
@Produces("appliction/json")
@Consumes("appliction/json")
public interface RootResource {

    @Path("/user")
    UserRestService getUsersRestService();

    @Path("/book")
    BookRestService getBooksRestService();

    @Path("/author")
    AuthorRestService getAuthorsRestService();

    @Path("/book/rental")
    BookRentalRestService getBooksRentalsRestService();

    @Path("/book/serie")
    BookSerieRestService getBookSeriesRestService();

    @Path("/characteristic")
    CharacteristicRestService getCharacteristicsRestService();

    @Path("/publisher")
    PublisherRestService getPublishersRestService();

    @Path("/genre")
    GenreRestService getGenresRestService();

    @Path("/workForm")
    WorkFormRestService getWorkformsRestService();

    @Path("/stockSignature")
    StockSignatureRestService getStockSignaturesRestService();

    @Path("/formatSignature")
    FormatSignatureRestService getFormatSignaturesRestService();

}
