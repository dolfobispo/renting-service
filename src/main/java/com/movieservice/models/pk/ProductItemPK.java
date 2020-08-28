package com.movieservice.models.pk;

import com.movieservice.models.Product;
import com.movieservice.models.Rent;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ProductItemPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "rent_id")
    private Rent rent;
    @ManyToOne
    @JoinColumn(name  = "product_id")
    private Product product;

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
