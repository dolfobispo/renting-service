package com.movieservice.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "tb_movie")
public class Movie  extends Product implements Serializable {
    private String posterPath;

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Movie(){}

    public Movie(Long id, String title, String overview, String posterPath,Double price) {
        this.posterPath = posterPath;
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.price = price;
    }
}
