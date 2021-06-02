package com.gocoding.noticeboard.controller;

import com.gocoding.noticeboard.dto.BoardDto;
import com.gocoding.noticeboard.entity.Board;
import com.gocoding.noticeboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping(value="/board")
    public String getBoard(Model model){
        List<Board> boardList = boardService.getBoardList();
        for(Board board: boardList){
            System.out.println(board.toString());
        }
        model.addAttribute("boardList", boardList);
        return "board";
    }


    @PostMapping(value="/postBoard")
    public String postBoard(@Valid BoardDto boardDto){
        boardService.postBoard(boardDto);

        return "redirect:/board";
    }
}
