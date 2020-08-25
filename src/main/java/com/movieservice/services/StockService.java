package com.movieservice.services;

import com.movieservice.models.Rent;
import com.movieservice.models.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockService {
    Stock get(Long id);
    List<Stock> getAll();
    Stock save(Stock stock);

}
