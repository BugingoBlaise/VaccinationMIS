package com.vac_mis.controller;

import com.vac_mis.model.Users;
import com.vac_mis.model.enums.ERole;
import com.vac_mis.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class UsersController {

    @Autowired
    private IUsersService userService;

    @PostMapping("/saveUser/{role}")
    public String saveUser(@ModelAttribute Users user, @PathVariable String role) {
        if ("NURSE".equals(role)) {
            saveNurse(user);
        } else if ("ADMIN".equals(role)) {
            saveAdmin(user);
        }
        return "redirect:/usersPage";
    }

    @GetMapping("/usersPage")
    public String indexPage(Model model) {
        model.addAttribute("usersForm", new Users());
        return "test";
    }

    private void saveNurse(Users user) {
        user.setId(UUID.randomUUID());
        user.setRole(ERole.NURSE);
        userService.saveUser(user);
    }

    private void saveAdmin(Users user) {
        user.setId(UUID.randomUUID());
        user.setRole(ERole.ADMIN);
        userService.saveUser(user);
    }
}
