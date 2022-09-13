package com.example.GoReview.models;

import com.example.GoReview.repositories.RestaurantRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

    @Entity(name = "restaurants")
    public class Restaurant {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "name")
        private String name;

        @Column(name = "location")
        private String location;

        @OneToMany(mappedBy = "restaurant")
        @JsonIgnoreProperties({"restaurant"})
        List<Review> reviews;

        public Restaurant(long id, String name, String location) {
            this.id = id;
            this.name = name;
            this.location = location;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public List<Review> getReviews() {
            return reviews;
        }

        public void setReviews(List<Review> reviews) {
            this.reviews = reviews;
        }


    }

