package com.movieservice.services;

import com.movieservice.models.Rent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentService {
    Rent get(Long id);
    List<Rent> getAll();
    Rent save(Rent order);

}
