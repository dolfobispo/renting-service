package com.movieservice.controllers;

import com.movieservice.dto.OrderDTO;
import com.movieservice.models.Order;
import com.movieservice.services.OrderService;
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
    private OrderService orderService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> get(@PathVariable Long id){
        Order order = orderService.get(id);
        return ResponseEntity.ok(OrderDTO.get(order));
    }
    @PostMapping
    public ResponseEntity<OrderDTO>save(@Valid @RequestBody Order order){
        Order orderResponse = orderService.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(OrderDTO.get(orderResponse));
    }
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAll(){
        List<OrderDTO> orderDTOS = orderService.getAll()
                .stream()
                .map(rent -> OrderDTO.get(rent)).collect(Collectors.toList());
        return ResponseEntity.ok(orderDTOS);
    }
}
