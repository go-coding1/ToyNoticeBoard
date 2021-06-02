package com.gocoding.noticeboard.service;

import com.gocoding.noticeboard.dto.BoardDto;
import com.gocoding.noticeboard.entity.Board;

import java.util.List;

public interface BoardService {
    Board getBoard(Long id);
    List<Board> getBoardList();
    void postBoard(BoardDto boardDto);
}
