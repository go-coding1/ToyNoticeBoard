package com.gocoding.noticeboard.controller;

import com.gocoding.noticeboard.dto.BoardDto;
import com.gocoding.noticeboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping(value="/board")
    public String getBoard(){
        return "board";
    }

    @PostMapping(value="/board")
    public void postBoard(@RequestBody @Valid BoardDto boardDto){

    }
}
