package com.vac_mis.controller;

import com.vac_mis.model.Users;
import com.vac_mis.model.enums.ERole;
import com.vac_mis.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class UsersController {
    @Autowired
    private IUsersService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Implement your authentication logic here (e.g., check credentials in the database)
        // If authentication is successful, redirect to a secure page; otherwise, show an error message.
        return "redirect:/secure-page";
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new Users());
        return "login";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute Users user) {
        // Implement your user registration logic here (e.g., save user details in the database)
        userService.saveUser(user);
        return "redirect:/login";
    }
}
