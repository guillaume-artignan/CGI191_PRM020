package com.example.cgi.model;

public class Avis {
    private String id;
    private String description;
    private Double nbStars;
    private String title;
    private String mail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getNbStars() {
        return nbStars;
    }

    public void setNbStars(Double nbStars) {
        this.nbStars = nbStars;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
