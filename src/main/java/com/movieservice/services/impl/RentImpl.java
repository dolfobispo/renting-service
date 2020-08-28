package com.movieservice.services.impl;

import com.movieservice.exceptions.ResourceNotFoundException;
import com.movieservice.models.RentItem;
import com.movieservice.models.Rent;
import com.movieservice.repositories.RentItemRepository;
import com.movieservice.repositories.RentRepository;
import com.movieservice.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentImpl implements RentService {
    @Autowired
    private RentRepository repository;
    @Autowired
    private RentItemRepository rentItemRepository;
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
       r.getItems().stream().forEach(orderItem -> {
          RentItem rentItem1 =  new RentItem(r, orderItem.getProduct(), orderItem.getQuantity(), orderItem.getPrice());
          rentItemRepository.save(rentItem1);
       });
       return rent;
    }
}
