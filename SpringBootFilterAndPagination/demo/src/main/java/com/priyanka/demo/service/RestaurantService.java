package com.priyanka.demo.service;

import com.priyanka.demo.model.Restaurant;
import com.priyanka.demo.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

     public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(new Restaurant(restaurant.getName(), restaurant.getCity(), restaurant.getRating()));
     }
     public List<Restaurant> getAllRestaurants(Pageable pageable) {

         Page<Restaurant> pageRestro=this.restaurantRepository.findAll(pageable);
         System.out.println(pageRestro.getTotalElements() + "all values" + pageRestro.getContent().toString());
         return pageRestro.getContent();
     }

    public List<Restaurant> getAllRestro() {

        return restaurantRepository.findAll();
    }

    public Page<Restaurant> getAllRestaurantsForCity(Pageable pageable, String city) {

        return restaurantRepository.findByCity(city,pageable);

    }

}
