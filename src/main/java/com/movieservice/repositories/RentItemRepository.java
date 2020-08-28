package com.movieservice.repositories;

import com.movieservice.models.RentItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentItemRepository extends JpaRepository<RentItem,Long> {
}
