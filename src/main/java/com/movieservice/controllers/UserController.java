package com.movieservice.controllers;

import com.movieservice.dto.UserDTO;
import com.movieservice.models.User;
import com.movieservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id){
        User user  = userService.get(id);
        return ResponseEntity.ok(UserDTO.get(user));
    }

    @PostMapping
    public ResponseEntity<UserDTO>save(@Valid @RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(UserDTO.get(userService.save(user)));
    }
    @PostMapping("/login")
    public ResponseEntity<UserDTO> findUserByEmailAndPassword(@RequestBody User user){
        return ResponseEntity.ok(UserDTO.get(userService.findUserByEmailAndPassword(user)));
    }

}
