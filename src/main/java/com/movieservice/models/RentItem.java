package com.movieservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.movieservice.models.pk.ProductItemPK;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_rent_item")
public class RentItem implements Serializable {

    @EmbeddedId
    private ProductItemPK id = new ProductItemPK();
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
    public RentItem(){}
    public RentItem(Rent rent, Product product , Integer quantity, Double price) {
        this.id.setRent(rent);
        this.id.setProduct(product) ;
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

    public Product getProduct(){
        return id.getProduct();
    }
    public void setProduct(Product product){
        id.setProduct(product);
    }
    public double getSubTotal(){
        return price * quantity;
    }
}
