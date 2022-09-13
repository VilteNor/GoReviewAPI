package com.example.GoReview.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id; //int?

    @Column(name="message")
    private String optionalMessage;
    @Column(name="visit_date")
    private String dateOfVisit;

    @Column(name="rating")
    private Rating rating; //enum pending

    @ManyToOne
    @JoinColumn(name = "username")
    @JsonIgnoreProperties({"reviews"})
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant")
    @JsonIgnoreProperties({"reviews"})
    private Restaurant restaurant;

    private List<Restaurant> restaurants;

//    enums pending

    public Review(User user, Restaurant restaurant, String dateOfVisit, Rating rating){
        this.user = user;
        this.restaurant = restaurant;
        this.dateOfVisit=dateOfVisit;
        this.rating=rating;
        this.optionalMessage="this review does not contain a message";

    }

    public Review(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public String getOptionalMessage() {
        return optionalMessage;
    }

    public void setOptionalMessage(String optionalMessage) {
        this.optionalMessage = optionalMessage;
    }

    public String getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(String dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addRestaurant(Restaurant restaurant){
        this.restaurants.add(restaurant);
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

}
