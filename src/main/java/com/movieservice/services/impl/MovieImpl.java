package com.movieservice.services.impl;

import com.movieservice.exceptions.EmailAlreadyExistsException;
import com.movieservice.exceptions.EntityAlreadyExitsException;
import com.movieservice.exceptions.ResourceNotFoundException;
import com.movieservice.models.Movie;
import com.movieservice.models.User;
import com.movieservice.repositories.MovieRepository;
import com.movieservice.repositories.UserRepository;
import com.movieservice.services.MovieService;
import com.movieservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieImpl implements MovieService {

    @Autowired
    private MovieRepository repository;

    @Override
    public Movie get(Long id) {
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
    }

    @Override
    public Movie save(Movie movie) {
        if(movie.getId()!=null){
            Optional<Movie> m = repository.findById(movie.getId());
            if(m.isPresent()){throw new EntityAlreadyExitsException("Filme já cadastrado");}
        }
        return repository.save(movie);
    }

    @Override
    public List<Movie> getAll() {
        return repository.findAll();
    }

}
