package com.movieservice.repositories;

import com.movieservice.models.MovieItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieItemRepository extends JpaRepository<MovieItem,Long> {
}
