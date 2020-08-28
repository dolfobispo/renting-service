package com.movieservice.repositories;
import com.movieservice.models.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent,Long> {
}
