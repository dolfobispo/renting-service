package com.movieservice.services.impl;

import com.movieservice.exceptions.EntityAlreadyExitsException;
import com.movieservice.exceptions.ResourceNotFoundException;
import com.movieservice.models.Movie;
import com.movieservice.models.Stock;
import com.movieservice.repositories.MovieRepository;
import com.movieservice.repositories.StockRepository;
import com.movieservice.services.MovieService;
import com.movieservice.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock get(Long id) {
        return stockRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
    }

    @Override
    public Stock save(Stock stock) {
        if(stock.getId()!=null){
            Optional<Stock> m = stockRepository.findById(stock.getId());
            if(m.isPresent()){throw new EntityAlreadyExitsException("Filme já cadastrado");}
        }
        return stockRepository.save(stock);
    }

    @Override
    public List<Stock> getAll() {
        return stockRepository.findAll();
    }

}
