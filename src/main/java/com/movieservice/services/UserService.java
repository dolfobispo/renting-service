package com.movieservice.services;
import com.movieservice.models.User;
import org.springframework.stereotype.Service;



@Service
public interface UserService {
    User get(Long id);
    User save(User user);
    User findUserByEmailAndPassword(User user);
    User findUserByCpf(String cpf);
}
