package com.aziz.dta.controllers;

import com.aziz.dta.models.User;
import com.aziz.dta.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    private final UserRepository userRepository;

    @Autowired
    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/index")
    @ResponseBody
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping
    public String login() {
        return "login2";
    }

    @PostMapping
    public String createUser(@PathVariable(value = "name") String name,
                             @PathVariable(value = "surname") String surname,
                             @PathVariable(value = "email") String email,
                             @PathVariable(value = "password") String password) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return "redirect:/index";
    }

    @PostMapping("/add-user")
    public String createWord(@ModelAttribute(value = "user") User user) {
        userRepository.save(user);
        return "redirect:/index";
    }
}
