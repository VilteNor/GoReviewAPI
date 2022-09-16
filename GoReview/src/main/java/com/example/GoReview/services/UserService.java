package com.example.GoReview.services;

import com.example.GoReview.models.Reply;
import com.example.GoReview.models.User;
import com.example.GoReview.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    public Reply checkExistingUser (User user) {
          if(!getAllUsers().contains(user)) {
              return new Reply(String.format("Could not find user %s. Would you like to create a new user?",
                    user.getUsername()));
          } else {
              return new Reply (String.format("User %s already exists.", user.getUsername()));
          }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void updateUserEmail (Long id, String email) {
        User user = userRepository.findById(id).get();
        user.setEmail(email);
    }

    public void updateUserFullName (Long id, String fullName) {
        User user = userRepository.findById(id).get();
        user.setFullName(fullName);
    }

    public Reply processUser(Map<String, String> userParams) {
        String username = (userParams.get("username"));
        String fullName = (userParams.get("fullName"));
        String email = (userParams.get("email"));
        if (getUserByUsername(username).isPresent()) {
            return new Reply("This username already exists, please try again.");
        } else if (getUserByEmail(email).isPresent()) {
            return new Reply("This email already exists, please try again.");
        } else {
            User user = new User(username, fullName, email);
            saveUser(user);
            return new Reply("User created successfully!");
        }
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
