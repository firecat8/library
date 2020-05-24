package com.library.domain.book;

import com.library.domain.Characteristic;
import com.library.domain.Entity;
import com.library.domain.Genre;
import com.library.domain.WorkForm;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class Book extends Entity {

    private String title;

    private String signature;

    private BookStates state;

    private Publisher publisher;

    private Year publishYear;

    private WorkForm form;

    private Author author;

    private BookSerie serie;

    private String inventoryNumber;

    private List<Genre> genres = new ArrayList<>();

    private List<Characteristic> characteristics = new ArrayList<>();

    public Book(String title, String ddcCode, BookStates state, Publisher publisher, WorkForm form, Author author, BookSerie serie, String inventoryNumber) {
        this.title = title;
        this.state = state;
        this.publisher = publisher;
        this.publishYear = Year.now();
        this.form = form;
        this.author = author;
        this.serie = serie;
        this.inventoryNumber = inventoryNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookStates getState() {
        return state;
    }

    public void setState(BookStates state) {
        this.state = state;
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

}
