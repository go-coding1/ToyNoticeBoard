package com.gocoding.noticeboard.controller;

import com.gocoding.noticeboard.entity.Member;
import com.gocoding.noticeboard.entity.ROLE;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {


    @GetMapping("/login")
    public void getLogin(){

    }

    @GetMapping("/register")
    public String getRegister(Model model){
        List<ROLE> role = new ArrayList<>();
        role.add(ROLE.ROLE_USER);
        role.add(ROLE.ROLE_MANAGER);
        role.add(ROLE.ROLE_ADMIN);
        model.addAttribute("list",role);
        return "register";
    }

}
