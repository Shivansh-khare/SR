package com.example.sr.Models;

public class Book_req_model {
    String name,author,publication,edition,request;

    public Book_req_model(String name, String author, String publication, String edition, String request) {
        this.name = name;
        this.author = author;
        this.publication = publication;
        this.edition = edition;
        this.request = request;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
