package com.gocoding.noticeboard.controller;

import com.gocoding.noticeboard.dto.BoardDto;
import com.gocoding.noticeboard.entity.Board;
import com.gocoding.noticeboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    //게시판 목록 조회 함수
    @GetMapping(value="/board")
    public ResponseEntity<List<Board>> getBoard(Model model){
        List<Board> boardList = boardService.getBoardList();
        for(Board board: boardList){
            System.out.println(board.toString());
        }
        model.addAttribute("boardList", boardList);
        return new ResponseEntity<List<Board>>(boardList, HttpStatus.OK);
    }

    //게시판 추가
    @PostMapping(value="/postBoard")
    public ResponseEntity<String> postBoard(@Valid BoardDto boardDto){
        boardService.postBoard(boardDto);

        return new ResponseEntity<String>(HttpStatus.OK);
    }

    //게시판 수정
    @PutMapping(value="/putBoard")
    public ResponseEntity<String> putBoard(@Valid Board board){
        boardService.putBoard(board);

        return new ResponseEntity<>("수정 되었습니다.", HttpStatus.OK);
    }

    //게시판 삭제
    @DeleteMapping(value="/deleteBoard")
    public ResponseEntity<String> deleteBoard(@Valid Board board){
        boardService.deleteBoard(board);

        return new ResponseEntity<>("삭제 되었습니다.", HttpStatus.OK);
    }
}
