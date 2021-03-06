package com.movieservice.repositories;

import com.movieservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByEmailAndPassword(String email,String password);
    Optional<User> findUserByCpf(String cpf);
}
