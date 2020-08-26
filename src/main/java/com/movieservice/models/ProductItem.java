package com.movieservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.movieservice.models.pk.ProductItemPK;

import javax.persistence.*;

@Entity
@Table(name = "tb_product_item")
public class ProductItem {

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
    public ProductItem(){}
    public ProductItem(Order order, Product product , Integer quantity, Double price) {
        this.id.setOrder(order);
        this.id.setProduct(product) ;
        this.quantity = quantity;
        this.price = price;
    }
    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }
    public void setOrder(Order order){
        id.setOrder(order);
    }
    @Basic(fetch = FetchType.EAGER)
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
