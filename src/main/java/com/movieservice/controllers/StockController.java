package com.movieservice.controllers;

import com.movieservice.models.Stock;
import com.movieservice.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    private StockService stockService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Stock> get(@PathVariable Long id){
        Stock stock  = stockService.get(id);
        return ResponseEntity.ok(stock);
    }
    @PostMapping
    public ResponseEntity<Stock>save(@RequestBody Stock stock){
        return ResponseEntity.status(HttpStatus.CREATED).body(stockService.save(stock));
    }
    @GetMapping
    public ResponseEntity<List<Stock>>getAll(){
        return ResponseEntity.ok(stockService.getAll());
    }
}
