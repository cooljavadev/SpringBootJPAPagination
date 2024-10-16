package com.priyanka.demo.repository;

import com.priyanka.demo.model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

   Page<Restaurant> findByCity(String city , Pageable pageable);
}
