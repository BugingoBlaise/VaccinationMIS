package com.vac_mis.controller;

import com.vac_mis.model.Users;
import com.vac_mis.model.enums.ERole;
import com.vac_mis.service.IUsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class UsersController {

    private final IUsersService userService;

    @Autowired
    public UsersController(IUsersService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    private final PasswordEncoder passwordEncoder;


    @GetMapping("/login")
    public String homePage(Model model) {
        model.addAttribute("log", new Users());
        return "login";
    }


    @PostMapping("/login/createAccount")
    public String signup(@ModelAttribute("log") Users user,Model model) {
        // Implement your user registration logic here (e.g., save user details in the database)
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRole(ERole.NURSE);

        userService.saveUser(user);
        model.addAttribute("infoMessage", "Account created successfully");

        return "redirect:/login";
    }
}
