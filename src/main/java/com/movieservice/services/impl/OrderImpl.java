package com.movieservice.services.impl;

import com.movieservice.exceptions.ResourceNotFoundException;
import com.movieservice.models.ProductItem;
import com.movieservice.models.Order;
import com.movieservice.repositories.ProductItemRepository;
import com.movieservice.repositories.OrderRepository;
import com.movieservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderImpl implements OrderService {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Override
    public Order get(Long id) {
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
    }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }

    @Override
    public Order save(Order order) {
       Order r = repository.save(order);
       r.getItems().stream().forEach(productItem -> {
          ProductItem productItem1 =  new ProductItem(r, productItem.getProduct(), productItem.getQuantity(), productItem.getPrice());
          productItemRepository.save(productItem1);
       });
       return order;
    }
}
