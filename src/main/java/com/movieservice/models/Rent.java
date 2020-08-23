package com.movieservice.models;

import com.movieservice.dto.UserDTO;
import com.movieservice.models.enums.RentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_rent")
public class Rent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

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

    @OneToMany(mappedBy = "id.rent",fetch = FetchType.EAGER)
    private Set<MovieItem> items = new HashSet<>();

    public Set<MovieItem> getItems() {
        return items;
    }

    public void setItems(Set<MovieItem> items) {
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

    public Rent(){

    }
    public Rent(Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
        this.rentStatus = RentStatus.RENTED;
    }
    public double getTotal(){
        double sum = 0.0;
        for(MovieItem movieItem: items){
            sum +=movieItem.getSubTotal();
        }
        return sum;
    }
}
