/*
 * Project library
 */
package com.library.dto.exchanger;

import com.library.domain.book.Characteristic;
import com.library.domain.book.Genre;
import com.library.domain.book.WorkForm;
import com.library.domain.book.Author;
import com.library.domain.book.Book;
import com.library.domain.book.BookSerie;
import com.library.domain.book.Publisher;
import com.library.dto.AuthorDto;
import com.library.dto.BookDto;
import com.library.dto.BookSerieDto;
import com.library.dto.CharacteristicDto;
import com.library.dto.GenreDto;
import com.library.dto.PublisherDto;
import com.library.dto.WorkFormDto;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author gdimitrova
 */
public class BookDtoExchanger extends DtoEntityExchanger<BookDto, Book> {

    public final static BookDtoExchanger INSTANCE = new BookDtoExchanger();

    private BookDtoExchanger() {
    }

    @Override
    protected Book exchangeFrom(BookDto dto) {
        Publisher publisher = PublisherDtoExchanger.INSTANCE.exchange(dto.getPublisher());
        WorkForm form = WorkFormDtoExchanger.INSTANCE.exchange(dto.getForm());
        Author author = AuthorDtoExchanger.INSTANCE.exchange(dto.getAuthor());

        BookSerieDto serie = dto.getSerie();
        BookSerie bookSerie = serie == null ? null : BookSerieDtoExchanger.INSTANCE.exchange(dto.getSerie());

        Book book = new Book(dto.getTitle(), dto.getSignature(), dto.getState(), dto.getStatus(), publisher, dto.getPublishYear(),
                form, author, bookSerie, dto.getInventoryNumber(), dto.getIsbn());

        List<Genre> genres = dto.getGenres().stream().map((g) -> {
            return GenreDtoExchanger.INSTANCE.exchange(g);
        }).collect(Collectors.toList());
        book.setGenres(genres);

        List<Characteristic> characteristics = dto.getCharacteristics().stream().map((c) -> {
            return CharacteristicDtoExchanger.INSTANCE.exchange(c);
        }).collect(Collectors.toList());
        book.setCharacteristics(characteristics);

        return book;
    }

    @Override
    protected BookDto exchangeFrom(Book e) {

        PublisherDto publisher = PublisherDtoExchanger.INSTANCE.exchange(e.getPublisher());
        WorkFormDto form = WorkFormDtoExchanger.INSTANCE.exchange(e.getForm());
        AuthorDto author = AuthorDtoExchanger.INSTANCE.exchange(e.getAuthor());
        BookSerie serie = e.getSerie();

        BookSerieDto bookSerie = serie == null ? null : BookSerieDtoExchanger.INSTANCE.exchange(e.getSerie());

        BookDto book = new BookDto(e.getTitle(), e.getSignature(), e.getState(), e.getStatus(), publisher, e.getPublishYear(),
                form, author, bookSerie, e.getInventoryNumber(), e.getISBN());

        Set<GenreDto> genres = e.getGenres().stream().map((g) -> {
            return GenreDtoExchanger.INSTANCE.exchange(g);
        }).collect(Collectors.toSet());
        book.setGenres(genres);

        Set<CharacteristicDto> characteristics = e.getCharacteristics().stream().map((c) -> {
            return CharacteristicDtoExchanger.INSTANCE.exchange(c);
        }).collect(Collectors.toSet());
        book.setCharacteristics(characteristics);

        return book;
    }


}
