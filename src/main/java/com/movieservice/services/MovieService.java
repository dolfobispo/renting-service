package com.movieservice.services;

import com.movieservice.models.Movie;
import com.movieservice.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    Movie get(Long id);
    Movie save(Movie movie);
    List<Movie> getAll();

}
