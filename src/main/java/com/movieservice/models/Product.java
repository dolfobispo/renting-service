package com.movieservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O titulo deve ser preenchido")
    private String title;
    @NotBlank(message = "A descrição deve ser preenchida")
    @Size(max = 1000)
    @Column(length = 1000)
    private String overview;
    private String poster_path;

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    private Stock stock;

    public Double getRent_price() {
        return rent_price;
    }

    public void setRent_price(Double price) {
        this.rent_price = price;
    }

    private Double rent_price;

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public Product(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Product(Long id, String title, String overview, String poster_path,Double price) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.rent_price = price;
    }
}
