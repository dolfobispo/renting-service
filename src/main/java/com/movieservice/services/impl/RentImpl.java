package com.movieservice.services.impl;

import com.movieservice.exceptions.ResourceNotFoundException;
import com.movieservice.models.MovieItem;
import com.movieservice.models.Rent;
import com.movieservice.repositories.MovieItemRepository;
import com.movieservice.repositories.RentRepository;
import com.movieservice.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RentImpl implements RentService {
    @Autowired
    private RentRepository repository;
    @Autowired
    private MovieItemRepository movieItemRepository;
    @Override
    public Rent get(Long id) {
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
    }

    @Override
    public List<Rent> getAll() {
        return repository.findAll();
    }

    @Override
    public Rent save(Rent rent) {
       Rent r = repository.save(rent);
       r.getItems().stream().forEach(movieItem -> {
          MovieItem movieItem1 =  new MovieItem(r,movieItem.getMovie(),movieItem.getQuantity(),movieItem.getPrice());
          movieItemRepository.save(movieItem1);
       });
       return rent;
    }
    public void rentIsValid(Rent rent){

    }
}
