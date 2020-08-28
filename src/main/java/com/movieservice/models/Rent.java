package com.movieservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.movieservice.models.enums.RentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_rent")
public class Rent  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Date rentingDate;
    private Date returningDate;
    private RentStatus rentStatus;
    private Instant moment;
    @OneToOne(mappedBy = "rent",cascade = CascadeType.ALL)
    private Payment payment;

    @OneToMany(mappedBy = "id.rent",fetch = FetchType.EAGER)
    Set<RentItem> items = new HashSet<>();

    public Instant getMoment() {
        return moment;
    }

    public Set<RentItem> getItems() {
        return items;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public User getClient() {
        return client;
    }
    public void setClient(User client) {
        this.client = client;
    }

    public Date getRentingDate() {
        return rentingDate;
    }

    public void setRentingDate(Date rentingDate) {
        this.rentingDate = rentingDate;
    }

    public Date getReturningDate() {
        return returningDate;
    }

    public void setReturningDate(Date returningDate) {
        this.returningDate = returningDate;
    }

    public RentStatus getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(RentStatus rentStatus) {
        this.rentStatus = rentStatus;
    }

    public Rent(){

    }
    public Rent(Long id, Date rentingDate, Date returningDate, RentStatus rentStatus,
                Instant moment, Payment payment, User client) {
        this.id = id;
        this.rentingDate = rentingDate;
        this.returningDate = returningDate;
        this.rentStatus = rentStatus;
        this.moment = moment;
        this.payment = payment;
        this.client = client;
    }

    public double getTotal(){
        double sum = 0.0;
        for(RentItem rentItem : items){
            sum += rentItem.getSubTotal();
        }
        return sum;
    }
}
