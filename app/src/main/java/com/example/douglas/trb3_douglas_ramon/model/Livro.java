package com.example.douglas.trb3_douglas_ramon.model;
import com.google.gson.annotations.SerializedName;

public class Livro {
    @SerializedName("id")
    int id;
    @SerializedName("title")
    String title;
    @SerializedName("subtitle")
    String subtitle;
    @SerializedName("author")
    String author;
    @SerializedName("publisher")
    String publisher;
    @SerializedName("publisherDate")
    String publisherDate;
    @SerializedName("description")
    String description;

    public Livro(int id, String title, String subtitle, String author, String publisher, String publisherDate, String description) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.author = author;
        this.publisher = publisher;
        this.publisherDate = publisherDate;
        this.description = description;
    }

    public Livro() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisherDate() {
        return publisherDate;
    }

    public void setPublisherDate(String publisherDate) {
        this.publisherDate = publisherDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
