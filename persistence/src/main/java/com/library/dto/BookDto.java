package com.library.dto;

import com.library.domain.book.BookStates;
import com.library.domain.book.BookStatus;
import java.time.Year;
import java.util.HashSet;
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

    public static final String STOCK_SIGNATURE = "stock_signature";

    public static final String FORMAT_SIGNATURE = "format_signature";

    public static final String STATE = "state";

    public static final String STATUS = "status";

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

    @Enumerated(EnumType.STRING)
    @Column(name = STATUS, nullable = false)
    private BookStatus status;

    @ManyToOne()
    @JoinColumn(name = PUBLISHER, nullable = false)
    private PublisherDto publisher;

    @ManyToOne()
    @JoinColumn(name = STOCK_SIGNATURE, nullable = true)
    private StockSignatureDto stockSignature;

    @ManyToOne()
    @JoinColumn(name = FORMAT_SIGNATURE, nullable = true)
    private FormatSignatureDto formatSignatureDto;

    @Column(name = PUBLISH_YEAR, nullable = false)
    private Year publishYear;

    @ManyToOne()
    @JoinColumn(name = FORM, nullable = false)
    private WorkFormDto form;

    @ManyToOne()
    @JoinColumn(name = AUTHOR, nullable = false)
    private AuthorDto author;

    @ManyToOne
    @JoinColumn(name = SERIE)
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
        //Hibernate
    }

    public BookDto(String title,  FormatSignatureDto formatSignatureDto,StockSignatureDto stockSignature, String signature, BookStates state, BookStatus status, PublisherDto publisher, Year publishYear, WorkFormDto form, AuthorDto author, BookSerieDto serie, String inventoryNumber, String isbn) {
        this.title = title;
        this.signature = signature;
        this.state = state;
        this.status = status;
        this.publisher = publisher;
        this.stockSignature = stockSignature;
        this.formatSignatureDto = formatSignatureDto;
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

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
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

    public StockSignatureDto getStockSignature() {
        return stockSignature;
    }

    public void setStockSignature(StockSignatureDto stockSignature) {
        this.stockSignature = stockSignature;
    }

    public FormatSignatureDto getFormatSignatureDto() {
        return formatSignatureDto;
    }

    public void setFormatSignatureDto(FormatSignatureDto formatSignatureDto) {
        this.formatSignatureDto = formatSignatureDto;
    }
    
    public Set<CharacteristicDto> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Set<CharacteristicDto> characteristics) {
        this.characteristics = characteristics;
    }

}
