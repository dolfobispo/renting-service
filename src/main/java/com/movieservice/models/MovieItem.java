package com.movieservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.movieservice.models.pk.MovieItemPK;

import javax.persistence.*;

@Entity
@Table(name = "tb_movie_item")
public class MovieItem {

    @EmbeddedId
    private MovieItemPK id = new MovieItemPK();
    private Integer quantity;
    private Double price;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public MovieItem(){}
    public MovieItem(Rent rent, Movie movie , Integer quantity, Double price) {
        this.id.setRent(rent);
        this.id.setMovie(movie) ;
        this.quantity = quantity;
        this.price = price;
    }
    @JsonIgnore
    public Rent getRent(){
        return id.getRent();
    }
    public void setRent(Rent rent){
        id.setRent(rent);
    }
    @Basic(fetch = FetchType.EAGER)
    public Movie getMovie(){
        return id.getMovie();
    }
    public void setMovie(Movie movie){
        id.setMovie(movie);
    }
    public double getSubTotal(){
        return price * quantity;
    }
}
