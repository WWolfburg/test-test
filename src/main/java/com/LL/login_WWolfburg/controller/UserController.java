package com.LL.login_WWolfburg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import com.LL.login_WWolfburg.model.User;
import com.LL.login_WWolfburg.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/api/users")
public class UserController {
  
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    

    @GetMapping("/Register")
    public String showRegistrationForm() {
        return "Register";
    }
    
    @PostMapping("/Register")
    public String registerUser(@ModelAttribute User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }
    
}
