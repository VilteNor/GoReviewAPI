# READ ME (GoReviewAPI 🍕)

GoReview is a restaurant review website API, which will help you make up your mind before you eat 😋


## Who we are 
__________________________________________

We are the team behind Go Review 

- Veron 🍜
    - Github : https://github.com/veron-eng
    - Linkedin : https://www.linkedin.com/in/veron-sundaram/

- Migle 🧁
    - Github : https://github.com/migleambr
    - Linkedin : https://www.linkedin.com/in/migle-ambrazeviciute-41133917b/  

- Vilte 🥯
    - Github :
    - Linkedin :

## Project Overview 
________________________

This collaborative project was completed as part of the Bright Network Technology Academy programme. This project aimed to build a back end for a restaurant review website, it consisted of a User who would log on to the website, and then place a review on one of their most recently visited restaurants. 

In the review the user can create a new restaurant if the restaurant is not already in the database, other functionality included in the review section are:
- the user can also give a rating out of 5
- give a rating of the price of the restaurant 
- an optional message 
- can attach lables to the review including, different types of accesible features and  diet 

The API was created using Java, and Spring boot, as well as, using Postman for testing.

## Table of Contents 
_______________________________
- [Instructions for Initial Setup](https://github.com/VilteNor/GoReviewAPI#step-by-step-instructions-for-initial-setup)
- [UML and ERD Diagrams](https://github.com/VilteNor/GoReviewAPI#uml-and-erd-diagrams)
- [Minimum Viable Product (MVP)](https://github.com/VilteNor/GoReviewAPI#minimum-viable-product-mvp)
- [Extensions](https://github.com/VilteNor/GoReviewAPI#extensions)
- [Plain Old Java Objects (POJOs)](https://github.com/VilteNor/GoReviewAPI#plain-old-java-objects-pojos)
- [HTTP Requests](https://github.com/VilteNor/GoReviewAPI#http-requests)

## Step-By-Step Instructions for Initial Setup 
_______________________________

1. Make sure that you have installed Java.
2. Clone this repository : git clone git@github.com:VilteNor/GoReviewAPI.git and open in you Java IDE
3. If you don't already have it, download Postman so that you can interact with the API, the HTTP quereis you will make will be on : localhost:8081/(command inserted here)

## UML and ERD Diagrams: 
_______________________________

## Minimum Viable Product (MVP): 
_______________________________

For our MVP we wanted to create an app with CRUD funtionality with 3x classes:
- Users
- Restaurants 
- Reviews

## Extensions: 
_______________________________

for our extentions we wanted to add the following functionality 

- get the average rating for each restaurant 
- create a moderator class, where when the user does complete a review it will enter the pending section, and be reviewed by the moderator 
- dont let a user write a review to the same restaurant for atleast 7 days
- retrieve a list of restaurants by using an inputted enum. 
- retrieve a list of reviews by using an inputted enum. 

## Plain Old Java Objects (POJOs): 
_______________________________

| pojo 	| type 	| input structure 	|
|---	|---	|---	|
| Users 	| -Id: long<br>- username: String<br>- fullName: String<br>- email: String<br>- reviews: list<Review> 	| {  <br>   "username": "veron02",  <br>   "fullname": "veron sundaram"<br>   "email":"veron@gmail.com"<br>} 	|
| Restaurants 	| - Id: long<br>- name: String<br>- location : String <br>- reviews : list<Review> 	| {  <br>    "name": "pizza express",<br>    "location": "new york"<br>} 	|
| Reviews 	| - Id: long<br>- restaurant : Restaurant <br>- optionalMessage : String<br>- username: User<br>- dateOfVisit : String<br>- optional enums : accessibility, pricing, cuisine, dietary requirements, rating 	| { <br>     "dateOfVisit":"09/08/89",<br>     "rating" : "COMPLETELY_DISSATISFIED",<br>     "accessibility":<br>            ["ACCESSIBLE_MENU",<br>            "ACCESSIBLE_BATHROOMS",<br>            "CHILD_FRIENDLY"],<br>     "optionalMessage":"food was amazing "<br>    <br>} 	|
| Reply 	| + message: String 	| N/a 	|

## HTTP Requests: 
_______________________________

### User:

| Request Type |             Request Path             |        Description       |
|--------------|--------------------------------------|--------------------------|
| **POST**     | localhost:8080/users                 | Add a new user           |  
| **GET**      | localhost:8080/users                 | Get all users            |
| **GET**      | localhost:8080/users/{id}            | Get user by id           |
| **PATCH**    | localhost:8080/users/{id}/email      | Update user's email      |
| **PATCH**    | localhost:8080/users/{id}/fullName   | Update user's full name  |
| **DELETE**   | localhost:8080/users/{id}            | Delete a user            |

**@POST requests**

To add a new user via a <mark style="background-color: lightblue">POST</mark> request in Postman, use JSON raw format and the following notations:

```
{
    "username" : "migle_ambr",
    "fullName" : "Migle Ambrazeviciute,
    "email" : "migle@gmail.com"
}
```

**@PATCH requests**

To update the user's details (either email or full name) via a <mark style="background-color: lightblue">PATCH</mark> request in Postman,, use JSON raw format and the following notations:

```
{
    "email" : "migle_new_email@gmail.com"
}
```

### Restaurant:

| Request Type |               Request Path              |              Description             |
|--------------|-----------------------------------------|--------------------------------------|
| **POST**     | localhost:8080/restaurants              | Add a new restaurant                 |
| **GET**      | localhost:8080/restaurants              | Get all restaurants                  |
| **GET**      | localhost:8080/restaurants/{id}         | Get restaurant by id                 |
| **GET**      | localhost:8080/restaurants/cuisine      | Get all restaurants by cuisine       |
| **GET**      | localhost:8080/restaurants/rating/{id}  | Get average rating for a restaurant  |
| **DELETE**   | localhost:8080/restaurants/{id}         | Delete a restaurant                  | 

**@POST requests**

To add a new restaurant via a <mark style="background-color: lightblue">POST</mark> request in Postman, use JSON raw format and the following notations (including an optional enum for cuisine):

```
{
    "name" : "Zizzi",
    "location" : "London",
    "cuisine" : "ITALIAN"
}
```

**@GET requests**

To get all restaurants and their associated reviews by a specific cuisine enum via a <mark style="background-color: lightblue">GET</mark> request in Postman, use JSON raw format and the following notation: 

```
"ITALIAN"
```

### Review:

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

**@POST requests**

To add a new review via a <mark style="background-color: lightblue">POST</mark> request in Postman, use JSON raw format and the following notations (including optional enums for diet, accessibility and pricing):

```
{
    "dateOfVisit":"6/4/2022",
    "rating": "GOOD",
    "optionalMessage": "would come back again :)",
    "diet" : [
        "DAIRY_FREE",
        "NUT_FREE"
    ],
    "accessibility" : [
        "ACCESSIBLE_BATHROOMS",
        "ACCESSIBLE_MENU"
    ],
    "pricing" : "£££"
}
```
**@GET requests**

To get all reviews by a specific diet, accessibility, pricing or rating enum via a <mark style="background-color: lightblue">GET</mark> request in Postman, use JSON raw format and the following notation: 

```
"GOOD"
```



## Testing: 
_______________________________

The project was tested through postman. The application created is the HTTP client and many http requests were wriiten as a way to test if the expected reponces were recieved,
preventing bugs and improving performance.


Here is an example of an example test:

<img width="988" alt="Screenshot 2022-09-16 at 10 39 37" src="https://user-images.githubusercontent.com/66369533/190608505-aeba90c4-582d-40c6-8d2d-27f8a0a13ae8.png">


## Final Comments: 
_______________________________

If we were to add further implementations to the project, we would add:
-  more of our extentions, but were not able to due to time constraints
- authentication and security features to our website through spring security
- some J-unit tests, or have worked in TDD style manner.


We would also like to acknoledge the BNTA team, and all the trainers for there amazing support during the program!