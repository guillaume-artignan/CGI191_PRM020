package com.example.cgi.model;

import com.example.cgi.SongActivity;

import java.io.Serializable;

public class Song implements Serializable {

    private Integer id;
    private String title;
    private String artist;

    public Song(Integer songID, String songTitle, String songArtist) {
        id=songID;
        title=songTitle;
        artist=songArtist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
