package com.priyanka.demo.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.util.UUID;

@Data
@Builder
public class RestaurantDTO {

    private UUID id;

    @NonNull
    private String name;

    @NonNull
    private String city;

    private int rating;

}
