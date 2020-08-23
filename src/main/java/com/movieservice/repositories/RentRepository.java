package com.movieservice.repositories;

import com.movieservice.models.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RentRepository extends JpaRepository<Rent,Long> {
}
