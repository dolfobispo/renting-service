package com.movieservice.services;

import com.movieservice.models.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order get(Long id);
    List<Order> getAll();
    Order save(Order order);

}
