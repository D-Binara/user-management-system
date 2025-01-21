package com.example.usermanagement.controller;

import com.example.usermanagement.model.User;
import com.example.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/add-user")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/add-user")
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id); // Call the service to delete the user by ID
        return "redirect:/users";  // Redirect to the users list page
    }
}
