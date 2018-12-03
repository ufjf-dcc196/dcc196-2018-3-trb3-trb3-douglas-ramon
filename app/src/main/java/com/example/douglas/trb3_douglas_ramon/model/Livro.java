package com.example.douglas.trb3_douglas_ramon.model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Livro {
    private int id;

    @SerializedName("name")
    String name;
    @SerializedName("publisher")
    String publisher;
    @SerializedName("numberOfPages")
    String numberOfPages;
    @SerializedName("authors")
    List<String> authors;
    @SerializedName("released")
    String released;

    public Livro(String name, List<String> authors, String publisher, String numberOfPages, String released) {
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
        this.released = released;
    }

    public Livro() { }

    public int getId() {
        return id;
    }

    public Livro setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Livro setName(String name) {
        this.name = name;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public Livro setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }

    public Livro setNumberOfPages(String numberOfPages) {
        this.numberOfPages = numberOfPages;
        return this;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public Livro setAuthors(List<String> authors) {
        this.authors = authors;
        return this;
    }

    public String getReleased() {
        return released;
    }

    public Livro setReleased(String released) {
        this.released = released;
        return this;
    }
}
