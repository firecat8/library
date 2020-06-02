package com.library.rest.api.vo.book;

import com.library.rest.api.vo.AbstractVo;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author gdimitrova
 */
public class BookVo extends AbstractVo {

    private String title;

    private String signature;

    private BookStatesVo state;

    private BookStatusVo status;

    private PublisherVo publisher;

    private Year publishYear;

    private WorkFormVo form;

    private AuthorVo author;

    private BookSerieVo serie;

    private String inventoryNumber;

    private String ISBN;

    private List<GenreVo> genres = new ArrayList<>();

    private List<CharacteristicVo> characteristics = new ArrayList<>();

    public BookVo() {
    }

    public BookVo(String title, String signature, BookStatesVo state, BookStatusVo status, PublisherVo publisher, Year publishYear, WorkFormVo form, AuthorVo author, BookSerieVo serie, String inventoryNumber, String ISBN) {
        this.title = title;
        this.signature = signature;
        this.state = state;
        this.status = status;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.form = form;
        this.author = author;
        this.serie = serie;
        this.inventoryNumber = inventoryNumber;
        this.ISBN = ISBN;
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

    public BookStatesVo getState() {
        return state;
    }

    public void setState(BookStatesVo state) {
        this.state = state;
    }

    public BookStatusVo getStatus() {
        return status;
    }

    public void setStatus(BookStatusVo status) {
        this.status = status;
    }

    public PublisherVo getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherVo publisher) {
        this.publisher = publisher;
    }

    public Year getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Year publishYear) {
        this.publishYear = publishYear;
    }

    public WorkFormVo getForm() {
        return form;
    }

    public void setForm(WorkFormVo form) {
        this.form = form;
    }

    public AuthorVo getAuthor() {
        return author;
    }

    public void setAuthor(AuthorVo author) {
        this.author = author;
    }

    public BookSerieVo getSerie() {
        return serie;
    }

    public void setSerie(BookSerieVo serie) {
        this.serie = serie;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public List<GenreVo> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreVo> genres) {
        this.genres = genres;
    }

    public List<CharacteristicVo> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<CharacteristicVo> characteristics) {
        this.characteristics = characteristics;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.title);
        hash = 17 * hash + Objects.hashCode(this.signature);
        hash = 17 * hash + Objects.hashCode(this.state);
        hash = 17 * hash + Objects.hashCode(this.status);
        hash = 17 * hash + Objects.hashCode(this.publisher);
        hash = 17 * hash + Objects.hashCode(this.publishYear);
        hash = 17 * hash + Objects.hashCode(this.form);
        hash = 17 * hash + Objects.hashCode(this.author);
        hash = 17 * hash + Objects.hashCode(this.serie);
        hash = 17 * hash + Objects.hashCode(this.inventoryNumber);
        hash = 17 * hash + Objects.hashCode(this.ISBN);
        hash = 17 * hash + Objects.hashCode(this.genres);
        hash = 17 * hash + Objects.hashCode(this.characteristics);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BookVo other = (BookVo) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.signature, other.signature)) {
            return false;
        }
        if (!Objects.equals(this.inventoryNumber, other.inventoryNumber)) {
            return false;
        }
        if (!Objects.equals(this.ISBN, other.ISBN)) {
            return false;
        }
        if (this.state != other.state) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.publisher, other.publisher)) {
            return false;
        }
        if (!Objects.equals(this.publishYear, other.publishYear)) {
            return false;
        }
        if (!Objects.equals(this.form, other.form)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.serie, other.serie)) {
            return false;
        }
        if (!Objects.equals(this.genres, other.genres)) {
            return false;
        }
        return Objects.equals(this.characteristics, other.characteristics);
    }

}
