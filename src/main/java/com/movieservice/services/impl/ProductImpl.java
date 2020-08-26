package com.movieservice.services.impl;

import com.movieservice.exceptions.EntityAlreadyExitsException;
import com.movieservice.exceptions.ResourceNotFoundException;
import com.movieservice.models.Product;
import com.movieservice.repositories.ProductRepository;
import com.movieservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product get(Long id) {
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
    }

    @Override
    public Product save(Product product) {
        if(product.getId()!=null){
            Optional<Product> m = repository.findById(product.getId());
            if(m.isPresent()){throw new EntityAlreadyExitsException("Filme já cadastrado");}
        }
        return repository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

}
