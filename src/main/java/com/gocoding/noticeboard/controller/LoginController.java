package com.gocoding.noticeboard.controller;

import com.gocoding.noticeboard.entity.Member;
import com.gocoding.noticeboard.entity.ROLE;
import com.gocoding.noticeboard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private MemberService memberService;

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

    @PostMapping("/register")
    public String postRegister(Member member){
        System.out.println(member.toString());
        memberService.setMember(member);

        return "login";
    }

}
