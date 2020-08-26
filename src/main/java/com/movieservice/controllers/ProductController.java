package com.movieservice.controllers;

import com.movieservice.models.Product;
import com.movieservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id){
        Product product  = productService.get(id);
        return ResponseEntity.ok(product);
    }
    @PostMapping
    public ResponseEntity<Product>save(@Valid @RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }
    @GetMapping
    public ResponseEntity<List<Product>>getAll(){
        return ResponseEntity.ok(productService.getAll());
    }
}
