package com.priyanka.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name ="restaurant")
@NoArgsConstructor
@Getter

public class Restaurant implements Comparable<Restaurant> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private String city;


    @Column(nullable = false)
    private int rating;

    public Restaurant(String name, String city, int rating) {
        this.name = name;
        this.city = city;
        this.rating = rating;
    }


    @Override
    public int compareTo(Restaurant o) {
        return o.rating - this.rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant that)) return false;
        return rating == that.rating && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, rating);
    }


}
