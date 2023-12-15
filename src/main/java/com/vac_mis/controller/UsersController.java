package com.vac_mis.controller;

import com.vac_mis.model.Users;
import com.vac_mis.model.enums.ERole;
import com.vac_mis.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//@RequestMapping("api/v1/admin")
@Controller
public class UsersController {
    @Autowired
    IUsersService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    String sender;


    @GetMapping("/home")
    public String homePage() {
        return "home";
    }


    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("log", new Users());
        return "login";
    }


    @PostMapping("/register")
    public String signup(@ModelAttribute("log") Users user, Model model) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(ERole.NURSE);
        userService.saveUser(user);
        model.addAttribute("infoMessage", "Account created successfully");

        SimpleMailMessage mailMessage
                = new SimpleMailMessage();

        mailMessage.setFrom(sender);
        mailMessage.setTo(user.getEmail());
        mailMessage.setText("Thank you for signup, welcome to our system " + user.getUsername() + "😉");
        mailMessage.setSubject("Welcome *.*");

        javaMailSender.send(mailMessage);
        return "redirect:/login";
    }
/*
    @PostMapping("/userLogin")
    public String userLogin(@ModelAttribute Users account, RedirectAttributes redirectAttributes, HttpSession session) {
        try {
            Authentication authentication = authenticationProvider.authenticate(
                    new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("Authenticated: " + authentication);

            System.out.println("Session ID: " + session.getId());
            System.out.println("Creation Time: " + session.getCreationTime());
            System.out.println("Last Accessed Time: " + session.getLastAccessedTime());

            return "redirect:/admin";
        } catch (BadCredentialsException ex) {
            redirectAttributes.addFlashAttribute("error", "Invalid username or password");
            return "redirect:login";
        }
    }*/


}


