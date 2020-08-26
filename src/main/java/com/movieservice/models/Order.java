package com.movieservice.models;

import com.movieservice.models.enums.RentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_rent")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    private Payment payment;

    private RentStatus rentStatus;

    public RentStatus getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(RentStatus rentStatus) {
        this.rentStatus = rentStatus;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @OneToMany(mappedBy = "id.order",fetch = FetchType.EAGER)
    private Set<ProductItem> items = new HashSet<>();

    public Set<ProductItem> getItems() {
        return items;
    }

    public void setItems(Set<ProductItem> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order(){

    }
    public Order(Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
        this.rentStatus = RentStatus.RENTED;
    }
    public double getTotal(){
        double sum = 0.0;
        for(ProductItem productItem : items){
            sum += productItem.getSubTotal();
        }
        return sum;
    }
}
