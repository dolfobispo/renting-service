package com.movieservice.models.pk;

import com.movieservice.models.Product;
import com.movieservice.models.Order;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ProductItemPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name  = "product_id")
    private Product product;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
