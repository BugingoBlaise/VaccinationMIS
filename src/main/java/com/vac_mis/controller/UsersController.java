package com.vac_mis.controller;

import com.vac_mis.model.Information;
import com.vac_mis.model.Users;
import com.vac_mis.model.enums.ERole;
import com.vac_mis.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {
    @Autowired
 private final   MailSender mailSender;
    @Autowired
    private final IUsersService userService;
    @Autowired
    private final PasswordEncoder passwordEncoder;
@Autowired
    public UsersController(MailSender mailSender, IUsersService userService, PasswordEncoder passwordEncoder) {
        this.mailSender = mailSender;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String homePage(Model model) {
        model.addAttribute("log", new Users());
        return "login";
    }


    @PostMapping("/login/createAccount")
    public String signup(@ModelAttribute("log") Users user, Model model) {
        // Implement your user registration logic here (e.g., save user details in the database)
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRole(ERole.NURSE);

        userService.saveUser(user);
//        sendEmail("blaisemugisha1@gmail.com","blaisemugisha1@outlook.com","JAVA","Hello "+user.getUsername()+" your Account was created successfully");
        model.addAttribute("infoMessage", "Account created successfully");

        return "redirect:/login";
    }

    /*public void sendEmail(String from, String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailSender.send(mailMessage);
    }*/

    @PostMapping("/auth")
    public String login(Users user) {
        // Perform authentication
        boolean isAuthenticated = userService.authenticateUser(user.getUsername(), user.getPassword());

        if (isAuthenticated) {
            // Redirect to a success page or perform any other action
            return "redirect:/info";
        } else {
            // Redirect back to login page with an error message
            return "redirect:/login?error";
        }
    }

}
