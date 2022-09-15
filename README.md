# GoReview API 

## Table of Contents:
* 
* 
* 

## Using the API

### POJOs (Plain Old Java Objects)



### HTTP Requests

**User**

Request Type |             Request Path             |        Description    
-------------+--------------------------------------+--------------------------
POST         | localhost:8080/users                 | Add a new user
-------------+--------------------------------------+--------------------------
GET          | localhost:8080/users                 | Get all users  
-------------+--------------------------------------+--------------------------
GET          | localhost:8080/users/{id}            | Get user by id
-------------+--------------------------------------+--------------------------
PATCH        | localhost:8080/users/{id}/email      | Update user's email
-------------+--------------------------------------+--------------------------
PATCH        | localhost:8080/users/{id}/fullName   | Update user's full name
-------------+--------------------------------------+--------------------------
DELETE       | localhost:8080/users/{id}            | Delete a user


add code block from postman for post requests & patch requests (in raw JSON)
- POST new user
- PATCH email

**Restaurant**

Request Type |               Request Path              |             Description    
-------------+-----------------------------------------+------------------------------------
POST         | localhost:8080/restaurants              | Add a new restaurant
-------------+-----------------------------------------+------------------------------------
GET          | localhost:8080/restaurants              | Get all restaurants  
-------------+-----------------------------------------+------------------------------------
GET          | localhost:8080/restaurants/{id}         | Get restaurant by id
-------------+-----------------------------------------+------------------------------------
GET          | localhost:8080/restaurants/cuisine      | Get all restaurants by cuisine
-------------+-----------------------------------------+------------------------------------
GET          | localhost:8080/restaurants/rating/{id}  | Get average rating for a restaurant
-------------+-----------------------------------------+------------------------------------
DELETE       | localhost:8080/restaurants/{id}         | Delete a restaurant


add code block from postman for post & get requests (in raw JSON)
- POST new restaurant
- GET restaurant by enum

**Review**

Request Type |                               Request Path                                 |              Description    
-------------+----------------------------------------------------------------------------+--------------------------------------
POST         | localhost:8080/reviews?username={username}&restaurantId={restaurantId}     | Submit a new review
-------------+----------------------------------------------------------------------------+---------------------------------------
GET          | localhost:8080/reviews                                                     | Get all reviews  
-------------+----------------------------------------------------------------------------+---------------------------------------
GET          | localhost:8080/reviews/{id}                                                | Get review by id
-------------+----------------------------------------------------------------------------+---------------------------------------
GET          | localhost:8080/reviews/users/{id}                                          | Get all reviews submited by a user
-------------+----------------------------------------------------------------------------+---------------------------------------
GET          | localhost:8080/reviews/username/{username}                                 | Get all reviews by username
-------------+----------------------------------------------------------------------------+---------------------------------------
GET          | localhost:8080/reviews/restaurant/{id}                                     | Get all reviews by restaurant id
-------------+----------------------------------------------------------------------------+---------------------------------------
GET          | localhost:8080/reviews/diet                                                | Get all reviews by diet type
-------------+----------------------------------------------------------------------------+---------------------------------------
GET          | localhost:8080/reviews/accessibility                                       | Get all reviews by accessibility type
-------------+----------------------------------------------------------------------------+---------------------------------------
GET          | localhost:8080/reviews/pricing                                             | Get all reviews by pricing
-------------+----------------------------------------------------------------------------+---------------------------------------
GET          | localhost:8080/reviews/rating                                              | Get all reviews by rating
-------------+----------------------------------------------------------------------------+---------------------------------------
DELETE       | localhost:8080/reviews/{id}                                                | Delete a review

- provide a list of elements available for each enum