package com.priyanka.demo.controller;

import com.priyanka.demo.model.Restaurant;
import com.priyanka.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api")
public class RestaurantsController {

    @Autowired
   RestaurantService restaurantService;

    @PostMapping("/restaurants")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant)  {
       // restaurantService.saveRestaurant(restaurant);
        return ResponseEntity.ok(restaurantService.saveRestaurant(restaurant));
    }



    @GetMapping("/restaurants")
    public ResponseEntity<Map<String, Object>> getAllRestaurantsInCity(
            @RequestParam(required = false) String city,
            @RequestParam(defaultValue = "5",required = false) int pageSize,
            @RequestParam(defaultValue = "0",required = false) int page
    ) {
        try {
            Pageable pageable= PageRequest.of(page,pageSize) ;
            Page<Restaurant> restroPage=restaurantService.getAllRestaurantsForCity(pageable,city);
            Map<String, Object> response = new HashMap<>();
            List <Restaurant> restaurantsUnsorted = new ArrayList<>();
                   restaurantsUnsorted.addAll( restroPage.getContent());

            Collections.sort(restaurantsUnsorted);
            //restaurantsUnsorted.reversed();
            response.put("restaurants", restaurantsUnsorted);
            response.put("currentPage", restroPage.getNumber());
            response.put("totalPages", restroPage.getTotalPages());
            response.put("totalElements", restroPage.getTotalElements());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }




    @GetMapping("/getall")
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        return ResponseEntity.ok(restaurantService.getAllRestro());
    }
}
