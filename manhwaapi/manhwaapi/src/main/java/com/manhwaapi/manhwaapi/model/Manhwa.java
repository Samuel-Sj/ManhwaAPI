package com.manhwaapi.manhwaapi.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
public class Manhwa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "releaseYear")
    @NotNull
    private int releaseYear;

    @Column(name = "isFinished")
    private Boolean isFinished = false;

    public Manhwa() {
    }

    public Manhwa(Long id, String name, int releaseYear, Boolean isFinished) {
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
        this.isFinished = isFinished;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }
}