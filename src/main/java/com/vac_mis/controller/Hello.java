package com.vac_mis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class Hello {
    @GetMapping("/")
    public String hello(){
        return "Hello world";
    }
}
