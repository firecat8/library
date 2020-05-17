package com.library.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class Book extends Entity {

    private String title;

    private BookStates state;

    private BookStatus status;

    private WorkForm form;

    private Author author;

    private BookSerie serie;

    private String inventoryNumber;

    private List<Genre> genres = new ArrayList<>();

    private List<Characteristic> characteristics = new ArrayList<>();

    public Book() {
    }

    public Book(String title, WorkForm form, Author author, BookSerie serie, String inventoryNumber, BookStates state, BookStatus status) {
        this.title = title;
        this.state = state;
        this.status = status;
        this.form = form;
        this.author = author;
        this.serie = serie;
        this.inventoryNumber = inventoryNumber;
    }

    public Book(String title, WorkForm form, Author author, BookSerie serie, String inventoryNumber, List<Characteristic> characteristics) {
        this(title, form, author, serie, inventoryNumber, BookStates.NEW, BookStatus.AVAILABLE);
        this.characteristics = characteristics;
    }

    public Book(String title, WorkForm form, Author author, BookSerie serie, String inventoryNumber) {
        this(title, form, author, serie, inventoryNumber, new ArrayList<Characteristic>());
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

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
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
