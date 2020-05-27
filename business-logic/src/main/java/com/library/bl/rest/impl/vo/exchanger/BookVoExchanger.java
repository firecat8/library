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
import com.library.rest.api.vo.book.AuthorVo;
import com.library.rest.api.vo.book.BookSerieVo;
import com.library.rest.api.vo.book.BookStatesVo;
import com.library.rest.api.vo.book.BookStatusVo;
import com.library.rest.api.vo.book.BookVo;
import com.library.rest.api.vo.book.CharacteristicVo;
import com.library.rest.api.vo.book.GenreVo;
import com.library.rest.api.vo.book.PublisherVo;
import com.library.rest.api.vo.book.WorkFormVo;
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

        BookSerieVo serie = vo.getSerie();
        BookSerie bookSerie = serie == null ? null : BookSerieVoExchanger.INSTANCE.exchange(vo.getSerie());

        Book book = new Book(vo.getTitle(), vo.getSignature(), 
                BookStates.valueOf(vo.getState().name()),
                BookStatus.valueOf(vo.getStatus().name()),
                publisher, vo.getPublishYear(),
                form, author, bookSerie, vo.getInventoryNumber(), vo.getISBN());

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
        BookSerie serie = e.getSerie();

        BookSerieVo bookSerie = serie == null ? null : BookSerieVoExchanger.INSTANCE.exchange(e.getSerie());

        BookVo book = new BookVo(e.getTitle(), e.getSignature(),
                BookStatesVo.valueOf(e.getState().name()),
                BookStatusVo.valueOf(e.getStatus().name()),
                publisher, e.getPublishYear(),
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
