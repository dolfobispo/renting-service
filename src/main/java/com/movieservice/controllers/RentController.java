package com.movieservice.controllers;

import com.movieservice.dto.RentDTO;
import com.movieservice.models.Rent;
import com.movieservice.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rents")
public class RentController {

    @Autowired
    private RentService rentService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<RentDTO> get(@PathVariable Long id){
        Rent rent  = rentService.get(id);
        return ResponseEntity.ok(RentDTO.get(rent));
    }
    @PostMapping
    public ResponseEntity<RentDTO>save(@Valid @RequestBody Rent rent){
        Rent rentResponse = rentService.save(rent);
        return ResponseEntity.status(HttpStatus.CREATED).body(RentDTO.get(rentResponse));
    }
    @GetMapping
    public ResponseEntity<List<RentDTO>> getAll(){
        List<RentDTO> rentDTOS = rentService.getAll()
                .stream()
                .map(rent -> RentDTO.get(rent)).collect(Collectors.toList());
        return ResponseEntity.ok(rentDTOS);
    }
}
