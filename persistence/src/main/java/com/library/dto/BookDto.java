package com.library.dto;

import com.library.domain.book.BookStates;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author gdimitrova
 */
@Entity(name = "books")
@Table(name = "books")
public class BookDto extends AbstractDto {

    public static final String TITLE = "title";

    public static final String SIGNATURE = "signature";

    public static final String STATE = "state";

    public static final String FORM = "form_id";

    public static final String PUBLISHER = "publisher_id";

    public static final String AUTHOR = "author_id";

    public static final String SERIE = "serie_id";

    public static final String PUBLISH_YEAR = "publish_year";

    public static final String INVENTORY_NUMBER = "inventory_number";

    public static final String ISBN = "isbn";

    @Column(name = TITLE, nullable = false)
    private String title;

    @Column(name = SIGNATURE, nullable = false)
    private String signature;

    @Enumerated(EnumType.STRING)
    @Column(name = STATE, nullable = false)
    private BookStates state;

    @ManyToOne
    @JoinColumn(name = PUBLISHER, nullable = false)
    private PublisherDto publisher;

    @Column(name = PUBLISH_YEAR, nullable = false)
    private Year publishYear;

    @ManyToOne
    @JoinColumn(name = FORM, nullable = false)
    private WorkFormDto form;

    @ManyToOne
    @JoinColumn(name = AUTHOR, nullable = false)
    private AuthorDto author;

    @ManyToOne
    @JoinColumn(name = SERIE, nullable = false)
    private BookSerieDto serie;

    @Column(name = INVENTORY_NUMBER, nullable = false)
    private String inventoryNumber;

    @Column(name = ISBN, nullable = false)
    private String isbn;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "book_genres",
            joinColumns = {
                @JoinColumn(name = "book_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "genre_id")}
    )
    private Set<GenreDto> genres = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "book_characteristics",
            joinColumns = {
                @JoinColumn(name = "book_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "characteristic_id")}
    )
    private Set<CharacteristicDto> characteristics = new HashSet<>();

    public BookDto() {
    }

    public BookDto(String title, String signature, BookStates state, PublisherDto publisher, Year publishYear, WorkFormDto form, AuthorDto author, BookSerieDto serie, String inventoryNumber, String isbn) {
        this.title = title;
        this.signature = signature;
        this.state = state;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.form = form;
        this.author = author;
        this.serie = serie;
        this.inventoryNumber = inventoryNumber;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public BookStates getState() {
        return state;
    }

    public void setState(BookStates state) {
        this.state = state;
    }

    public PublisherDto getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherDto publisher) {
        this.publisher = publisher;
    }

    public Year getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Year publishYear) {
        this.publishYear = publishYear;
    }

    public WorkFormDto getForm() {
        return form;
    }

    public void setForm(WorkFormDto form) {
        this.form = form;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public BookSerieDto getSerie() {
        return serie;
    }

    public void setSerie(BookSerieDto serie) {
        this.serie = serie;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<GenreDto> getGenres() {
        return genres;
    }

    public void setGenres(Set<GenreDto> genres) {
        this.genres = genres;
    }

    public Set<CharacteristicDto> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Set<CharacteristicDto> characteristics) {
        this.characteristics = characteristics;
    }

}
