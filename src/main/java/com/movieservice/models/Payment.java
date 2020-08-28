package com.movieservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name ="tb_payment")
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    @OneToOne
    @MapsId
    @JsonIgnore
    private Rent rent;

    public Payment(){

    }
    public Payment(Long id, Instant moment, Rent rent) {
        this.id = id;
        this.moment = moment;
        this.rent = rent;
    }

    public Long getId() {
        return this.id;
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

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
