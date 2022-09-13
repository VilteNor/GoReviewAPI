package com.example.GoReview.services;

import com.example.GoReview.models.Reply;
import com.example.GoReview.models.User;
import com.example.GoReview.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Reply processUser(User user) {
        if(getAllUsers().contains(user.getUsername()) || getAllUsers().contains(user.getEmail())) {
            return new Reply("This user already exists, please try again.");
        } else {
            saveUser(user);
            return new Reply("User created successfully!");
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
