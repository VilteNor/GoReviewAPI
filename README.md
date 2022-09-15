# READ ME (GoReviewAPI )

GoReview is a restaurant review website API, which will help you make up your mind before you eat.


## Who we are 
__________________________________________

We are the team behind Go Review 

- Veron 
    - Github :
    - Linkedin :

- Migle 
    - Github :
    - Linkedin :

- Vilte 
    - Github :
    - Linkedin :

## Project Overview 
________________________

This collaborative project was completed as part of the Bright Network Technology Academy programme. This project aimed to build a back end for a restaurant review website, it consisted of a User who would log on to the website, and then place a review on one of their favourite restaurants. 

In the review the user can create a new restaurant if the restaurant is not already in the database, other functionality included in the review section are:
- the user can also give a rating out of 5
- give a rating of the price of the restaurant 
- an optional message 
- can attach lables to the review including, different types of accesible features and  diet 

The API was created using Java, and Spring boot, as well as, using Postman for testing.

## Table of contents 
_______________________________
-
-

## Step-By-Step instructions for initial setup 
_______________________________

1. Make sure that you have installed Java.
2. Clone this repository : git clone git@github.com:VilteNor/GoReviewAPI.git and open in you Java IDE
3. If you don't already have it, download Postman so that you can interact with the API, the HTTP quereis you will make will be on : localhost:8081/(command inserted here)


## Minimum Viable Product (MVP): 
_______________________________

For our MVP we wanted to create an app with CRUD funtionality with 3x classes:
- Users
- Restaurants 
- Reviews

## extentions: 
_______________________________

for our extentions we wanted to add the following functionality 

- get the average rating for each restaurant 
- create a moderator class, where when the user does complete a review it will enter the pending section, and be reviewed by the moderator 
- dont let a user write a review to the same restaurant for atleast 7 days
- retrieve a list of restaurants by using an inputted enum. 
- retrieve a list of reviews by using an inputted enum. 

## Plain Old Java Objects (POJOS): 
_______________________________

| pojo 	| type 	| input structure 	|  	|  	|
|---	|---	|---	|---	|---	|
| Users 	| -Id: long<br>- username: String<br>- fullName: String<br>- email: String<br>- reviews: list<Review> 	| { "username": "veron02",  <br>  "fullname": "veron sundaram"<br>   "email":"veron@gmail.com"<br>, 	|  	|  	|
| Restaurants 	| - Id: long<br>- name: String<br>- location : String <br>- reviews : list<Review> 	|  	|  	|  	|
| reviews 	| - Id: long<br>- restaurant : Restaurant <br>- optionalMessage : String<br>- username: User<br>- enums......<br>- dateOfVisit : String 	|  	|  	|  	|





### HTTP Requests

### User:

| Request Type |             Request Path             |        Description       |
|--------------|--------------------------------------|--------------------------|
| **POST**     | localhost:8080/users                 | Add a new user           |  
| **GET**      | localhost:8080/users                 | Get all users            |
| **GET**      | localhost:8080/users/{id}            | Get user by id           |
| **PATCH**    | localhost:8080/users/{id}/email      | Update user's email      |
| **PATCH**    | localhost:8080/users/{id}/fullName   | Update user's full name  |
| **DELETE**   | localhost:8080/users/{id}            | Delete a user            |

add code block from postman for post requests & patch requests (in raw JSON)
- POST new user
- PATCH email

## Restaurant:

| Request Type |               Request Path              |              Description             |
|--------------|-----------------------------------------|--------------------------------------|
| **POST**     | localhost:8080/restaurants              | Add a new restaurant                 |
| **GET**      | localhost:8080/restaurants              | Get all restaurants                  |
| **GET**      | localhost:8080/restaurants/{id}         | Get restaurant by id                 |
| **GET**      | localhost:8080/restaurants/cuisine      | Get all restaurants by cuisine       |
| **GET**      | localhost:8080/restaurants/rating/{id}  | Get average rating for a restaurant  |
| **DELETE**   | localhost:8080/restaurants/{id}         | Delete a restaurant                  | 

add code block from postman for post & get requests (in raw JSON)
- POST new restaurant
- GET restaurant by enum

## Review:

| Request Type |                               Request Path                                 |              Description                |
|--------------|----------------------------------------------------------------------------|-----------------------------------------|
| **POST**     | localhost:8080/reviews?username={username}&restaurantId={restaurantId}     | Submit a new review                     |
| **GET**      | localhost:8080/reviews                                                     | Get all reviews                         |
| **GET**      | localhost:8080/reviews/{id}                                                | Get review by id                        |  
| **GET**      | localhost:8080/reviews/users/{id}                                          | Get all reviews submited by a user      |
| **GET**      | localhost:8080/reviews/username/{username}                                 | Get all reviews by username             | 
| **GET**      | localhost:8080/reviews/restaurant/{id}                                     | Get all reviews by restaurant id        |  
| **GET**      | localhost:8080/reviews/diet                                                | Get all reviews by diet type            |
| **GET**      | localhost:8080/reviews/accessibility                                       | Get all reviews by accessibility type   |
| **GET**      | localhost:8080/reviews/pricing                                             | Get all reviews by pricing              |
| **GET**      | localhost:8080/reviews/rating                                              | Get all reviews by rating               |
| **DELETE**   | localhost:8080/reviews/{id}                                                | Delete a review                         |

- provide a list of elements available for each enum