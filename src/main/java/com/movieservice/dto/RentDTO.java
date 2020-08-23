package com.movieservice.dto;

import com.movieservice.models.MovieItem;
import com.movieservice.models.Rent;
import com.movieservice.models.User;
import com.movieservice.models.enums.RentStatus;

import java.time.Instant;
import java.util.Set;

public class RentDTO {

    private Long id;
    private Instant moment;
    private Set<MovieItem> items;
    private double total;
    private int rentStatus;
    private UserDTO client;

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

    public RentDTO(Rent rent) {
        this.id = rent.getId();
        this.moment = rent.getMoment();
        this.client = UserDTO.getUserRentDTO(rent.getClient());
        this.items = rent.getItems();
        this.total = this.getTotal(rent);
        this.rentStatus = rent.getRentStatus().getCode();
    }
    public RentDTO(){ }


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


    public Set<MovieItem> getItems() {
        return items;
    }

    public void setItems(Set<MovieItem> items) {
        this.items = items;
    }

    public static RentDTO get (Rent rent){
        return new RentDTO(rent);
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public double getTotal(Rent rent){
        return rent.getTotal();
    }

}
