package com.sg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String releaseDate;
    private String description;

    @Override
    public String toString() {
        return "Release{" +
                "id=" + id +
                ", releaseDate='" + releaseDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Release() {
    }

    public Release(Long id, String description, String releaseDate){
        this.id = id;
        this.releaseDate = releaseDate;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

