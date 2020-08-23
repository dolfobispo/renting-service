package com.movieservice.models.pk;

import com.movieservice.models.Movie;
import com.movieservice.models.Rent;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class MovieItemPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "rent_id")
    private Rent rent;
    @ManyToOne
    @JoinColumn(name  = "movie_id")
    private Movie movie;

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
