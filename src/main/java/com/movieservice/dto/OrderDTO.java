package com.movieservice.dto;

import com.movieservice.models.ProductItem;
import com.movieservice.models.Payment;
import com.movieservice.models.Order;

import java.time.Instant;
import java.util.Set;

public class OrderDTO {

    private Long id;
    private Instant moment;
    private Set<ProductItem> items;
    private double total;
    private int rentStatus;
    private UserDTO client;
    private Payment payment;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public UserDTO getClient() {
        return client;
    }

    public void setClient(UserDTO client) {
        this.client = client;
    }

    public int getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(int rentStatus) {
        this.rentStatus = rentStatus;
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.moment = order.getMoment();
        this.client = UserDTO.getUserRentDTO(order.getClient());
        this.items = order.getItems();
        this.total = this.getTotal(order);
        this.rentStatus = order.getRentStatus().getCode();
        this.payment = order.getPayment();
    }
    public OrderDTO(){ }


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


    public Set<ProductItem> getItems() {
        return items;
    }

    public void setItems(Set<ProductItem> items) {
        this.items = items;
    }

    public static OrderDTO get (Order order){
        return new OrderDTO(order);
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public double getTotal(Order order){
        return order.getTotal();
    }

}
