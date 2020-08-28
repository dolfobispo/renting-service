package com.movieservice.controllers;
import com.movieservice.models.Rent;
import com.movieservice.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rents")
public class RentController {

    @Autowired
    private RentService rentService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Rent> get(@PathVariable Long id){
        return ResponseEntity.ok(rentService.get(id));
    }
    @PostMapping
    public ResponseEntity<Rent>save(@Valid @RequestBody Rent rent){
        return ResponseEntity.status(HttpStatus.CREATED).body(rentService.save(rent));
    }
    @GetMapping
    public ResponseEntity<List<Rent>> getAll(){
        return ResponseEntity.ok(rentService.getAll());
    }
}
