package com.movieservice.services.impl;

import com.movieservice.exceptions.EmailAlreadyExistsException;
import com.movieservice.exceptions.ResourceNotFoundException;
import com.movieservice.models.User;
import com.movieservice.repositories.UserRepository;
import com.movieservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository repository;
    public User get(Long id){
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
    }

    @Override
    public User save(User user){
        Optional<User> u = repository.findUserByEmail(user.getEmail());
        if(u.isPresent()){throw new EmailAlreadyExistsException();}
        return repository.save(user);
    }

    public User findUserByEmailAndPassword(User user){
        return repository.findUserByEmailAndPassword(user.getEmail(),user.getPassword()).orElseThrow(()->new ResourceNotFoundException(0l));
    }

    @Override
    public User findUserByCpf(String cpf) {
       return repository.findUserByCpf(cpf).orElseThrow(()->new ResourceNotFoundException(0l));
    }

}
