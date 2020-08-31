package com.movieservice.services.impl;

import com.movieservice.advices.ConstraintViolationError;
import com.movieservice.exceptions.ResourceNotFoundException;
import com.movieservice.models.Product;
import com.movieservice.models.RentItem;
import com.movieservice.models.Rent;
import com.movieservice.models.Stock;
import com.movieservice.models.enums.RentStatus;
import com.movieservice.repositories.ProductRepository;
import com.movieservice.repositories.RentItemRepository;
import com.movieservice.repositories.RentRepository;
import com.movieservice.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import javax.validation.ConstraintViolationException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class RentImpl implements RentService {
    @Autowired
    private RentRepository repository;
    @Autowired
    private RentItemRepository rentItemRepository;
    @Autowired
    private ProductRepository productRepository;
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
        rent.getPayment().setRent(rent);
        rent.setMoment(Instant.now());
        rent.setRentStatus(RentStatus.RENTED);
        Rent r = repository.save(rent);
        r.getItems().stream().forEach(rentItem -> {
            writeOffStock(rentItem);
            rentItem.setRent(r);
            rentItemRepository.save(rentItem);
        });
        return rent;
    }
    private void writeOffStock(RentItem rentItem){
        Optional<Product> product = productRepository.findById(rentItem.getProduct().getId());
        Stock stock = product.get().getStock();
        stock.setQuantity(stock.getQuantity() - rentItem.getQuantity());
        stock.setProduct(product.get());
        productRepository.save(product.get());


    }
}
