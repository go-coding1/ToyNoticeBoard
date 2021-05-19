package com.gocoding.noticeboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/user")
    public void getUser(){
        System.out.println("Get Request User");
    }

    @GetMapping("/manager")
    public void getManager(){
        System.out.println("Get Request Manager");
    }

    @GetMapping("/admin")
    public void getAdmin(){
        System.out.printf("Get Request Admin");
    }
}
