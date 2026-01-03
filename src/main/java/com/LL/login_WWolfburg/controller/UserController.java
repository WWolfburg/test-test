package com.LL.login_WWolfburg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LL.login_WWolfburg.model.User;
import com.LL.login_WWolfburg.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
public class UserController {
  
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping
    public Iterable<User> findAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
        public User findUserById(@PathVariable("id") Integer id){
            return userRepository.findById(id).orElse(null);
        }
    
    @PostMapping("/Register")
    public User registerUser(@RequestBody User user){
        return userRepository.save(user);
    }
    
}
