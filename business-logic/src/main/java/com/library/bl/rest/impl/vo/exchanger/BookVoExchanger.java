/*
 * Project library
 */
package com.library.bl.rest.impl.vo.exchanger;

import com.library.domain.book.Characteristic;
import com.library.domain.book.Genre;
import com.library.domain.book.WorkForm;
import com.library.domain.book.Author;
import com.library.domain.book.Book;
import com.library.domain.book.BookSerie;
import com.library.domain.book.BookStates;
import com.library.domain.book.BookStatus;
import com.library.domain.book.Publisher;
import com.library.domain.book.signature.FormatSignature;
import com.library.domain.book.signature.StockSignature;
import com.library.rest.api.vo.YearVo;
import com.library.rest.api.vo.book.AuthorVo;
import com.library.rest.api.vo.book.BookSerieVo;
import com.library.rest.api.vo.book.BookStatesVo;
import com.library.rest.api.vo.book.BookStatusVo;
import com.library.rest.api.vo.book.BookVo;
import com.library.rest.api.vo.book.CharacteristicVo;
import com.library.rest.api.vo.book.GenreVo;
import com.library.rest.api.vo.book.PublisherVo;
import com.library.rest.api.vo.book.WorkFormVo;
import com.library.rest.api.vo.book.signature.FormatSignatureVo;
import com.library.rest.api.vo.book.signature.StockSignatureVo;
import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author gdimitrova
 */
public class BookVoExchanger extends VoEntityExchanger<BookVo, Book> {

    public final static BookVoExchanger INSTANCE = new BookVoExchanger();

    private BookVoExchanger() {
    }

    @Override
    protected Book exchangeFrom(BookVo vo) {
        Publisher publisher = PublisherVoExchanger.INSTANCE.exchange(vo.getPublisher());
        WorkForm form = WorkFormVoExchanger.INSTANCE.exchange(vo.getForm());
        Author author = AuthorVoExchanger.INSTANCE.exchange(vo.getAuthor());
        StockSignature stockSignature = StockSignatureVoExchanger.INSTANCE.exchange(vo.getStockSignature());
        FormatSignature formatSignature = FormatSignatureVoExchanger.INSTANCE.exchange(vo.getFormatSignature());

        BookSerieVo serie = vo.getSerie();
        BookSerie bookSerie = serie == null ? null : BookSerieVoExchanger.INSTANCE.exchange(vo.getSerie());

        Book book = new Book(vo.getTitle(), formatSignature, stockSignature, vo.getSignature(),
                BookStates.valueOf(vo.getState().name()),
                BookStatus.valueOf(vo.getStatus().name()),
                publisher, Year.parse(vo.getPublishYear().toString()),
                form, author, bookSerie, vo.getInventoryNumber(), vo.getisbn());

        List<Genre> genres = vo.getGenres().stream().map((g) -> {
            return GenreVoExchanger.INSTANCE.exchange(g);
        }).collect(Collectors.toList());
        book.setGenres(genres);

        List<Characteristic> characteristics = vo.getCharacteristics().stream().map((c) -> {
            return CharacteristicVoExchanger.INSTANCE.exchange(c);
        }).collect(Collectors.toList());
        book.setCharacteristics(characteristics);

        return book;
    }

    @Override
    protected BookVo exchangeFrom(Book e) {

        PublisherVo publisher = PublisherVoExchanger.INSTANCE.exchange(e.getPublisher());
        WorkFormVo form = WorkFormVoExchanger.INSTANCE.exchange(e.getForm());
        AuthorVo author = AuthorVoExchanger.INSTANCE.exchange(e.getAuthor());
        StockSignatureVo stockSignature = StockSignatureVoExchanger.INSTANCE.exchange(e.getStockSignature());
        FormatSignatureVo formatSignature = FormatSignatureVoExchanger.INSTANCE.exchange(e.getFormatSignature());
        BookSerie serie = e.getSerie();

        BookSerieVo bookSerie = serie == null ? null : BookSerieVoExchanger.INSTANCE.exchange(e.getSerie());

        BookVo book = new BookVo(e.getTitle(), formatSignature, stockSignature, e.getSignature(),
                BookStatesVo.valueOf(e.getState().name()),
                BookStatusVo.valueOf(e.getStatus().name()),
                publisher, new YearVo(e.getPublishYear().getValue()),
                form, author, bookSerie, e.getInventoryNumber(), e.getISBN());

        List<GenreVo> genres = e.getGenres().stream().map((g) -> {
            return GenreVoExchanger.INSTANCE.exchange(g);
        }).collect(Collectors.toList());
        book.setGenres(genres);

        List<CharacteristicVo> characteristics = e.getCharacteristics().stream().map((c) -> {
            return CharacteristicVoExchanger.INSTANCE.exchange(c);
        }).collect(Collectors.toList());
        book.setCharacteristics(characteristics);

        return book;
    }

}
