package com.library.domain.book;

import com.library.domain.Entity;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author gdimitrova
 */
public class Book extends Entity {

    private String title;

    private String signature;

    private BookStates state;

    private BookStatus status;

    private Publisher publisher;

    private Year publishYear;

    private WorkForm form;

    private Author author;

    private BookSerie serie;

    private String inventoryNumber;

    private String ISBN;

    private List<Genre> genres = new ArrayList<>();

    private List<Characteristic> characteristics = new ArrayList<>();

    public Book(String title, String signature, BookStates state, BookStatus status, Publisher publisher, Year publishYear, WorkForm form, Author author, BookSerie serie, String inventoryNumber, String ISBN) {
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

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Year getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Year publishYear) {
        this.publishYear = publishYear;
    }

    public WorkForm getForm() {
        return form;
    }

    public void setForm(WorkForm form) {
        this.form = form;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookSerie getSerie() {
        return serie;
    }

    public void setSerie(BookSerie serie) {
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

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<Characteristic> characteristics) {
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
        final Book other = (Book) obj;
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
