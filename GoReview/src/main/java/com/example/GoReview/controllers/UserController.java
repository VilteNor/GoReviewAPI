package com.example.GoReview.controllers;

import com.example.GoReview.models.Reply;
import com.example.GoReview.models.User;
import com.example.GoReview.repositories.UserRepository;
import com.example.GoReview.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    

    // how to make sure it updates the same account and doesn't create a new user?
    @PatchMapping(value = "/{id}/email")
    public ResponseEntity<User> updateUserEmail(@PathVariable Long id, @RequestBody Map<String, String> bodyParams) {
        User user = userService.getUserById(id).get();
        //user.setEmail(bodyParams.get("email")); // create updateEmail method in userService
        userService.updateUserEmail(id, bodyParams.get("email"));
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reply> addNewUser(@RequestBody Map<String, String> userParams) {
        Reply reply = userService.processUser(userParams);
        return new ResponseEntity<>(reply, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

}
