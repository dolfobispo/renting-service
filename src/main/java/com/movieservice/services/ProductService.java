package com.movieservice.services;

import com.movieservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product get(Long id);
    Product save(Product product);
    List<Product> getAll();

}
