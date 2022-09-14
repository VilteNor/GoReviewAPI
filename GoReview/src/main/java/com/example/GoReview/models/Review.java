package com.example.GoReview.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="message")
    private String optionalMessage;
    @Column(name="visit_date")
    private String dateOfVisit;

    @Column(name="rating")
    private Rating rating;

    @Column(name="pricing")
    private Pricing pricing;


    @ElementCollection
    @Column(name = "diet")
    private List<Diet> diets;


    @ElementCollection
    @Column(name = "accessibilities")
    private List<Accessibility> accessibilities;



    @ManyToOne
    @JoinColumn(name = "username")
    @JsonIgnoreProperties({"reviews"})
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonIgnoreProperties({"reviews"})
    private Restaurant restaurant;


//    enums pending

    public Review(User user, Restaurant restaurant, String dateOfVisit, Rating rating){
        this.user = user;
        this.restaurant = restaurant;
        this.dateOfVisit=dateOfVisit;
        this.rating= rating;
        this.optionalMessage="this review does not contain a message";

        this.accessibilities= new ArrayList<>();
        this.diets= new ArrayList<>();

        this.pricing = null;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }


    public List<Diet> getDiet() {
        return diets;
    }

    public void setDiet(List<Diet> diet) {
        this.diets = diet;
    }

    public List<Accessibility> getAccessibility() {
        return accessibilities;
    }

    public void setAccessibility(List<Accessibility> accessibility) {
        this.accessibilities = accessibility;
        };

    public void addAccessibility(Accessibility accessibility) {
        this.accessibilities.add(accessibility);
    }

    public void addDiet(Diet diet) {
        this.diets.add(diet);
    }



    public Review(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

}
