package com.manhwaapi.manhwaapi.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.IdGeneratorType;

@Entity
public class Manhwa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "releaseYear")
    @NotNull
    private int releaseYear;

    @Column(name = "isFinished")
    private boolean isFinished;

    public Manhwa (long id, String name, int releaseYear, boolean isFinished){
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
        this.isFinished = isFinished;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName(){
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

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
