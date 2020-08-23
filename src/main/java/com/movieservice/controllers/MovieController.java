package com.movieservice.controllers;

import com.movieservice.dto.UserDTO;
import com.movieservice.models.Movie;
import com.movieservice.models.User;
import com.movieservice.services.MovieService;
import com.movieservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> get(@PathVariable Long id){
        Movie movie  = movieService.get(id);
        return ResponseEntity.ok(movie);
    }
    @PostMapping
    public ResponseEntity<Movie>save(@Valid @RequestBody Movie movie){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.save(movie));
    }
    @GetMapping
    public ResponseEntity<List<Movie>>getAll(){
        return ResponseEntity.ok(movieService.getAll());
    }
}
