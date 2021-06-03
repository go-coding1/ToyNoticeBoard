package com.gocoding.noticeboard.service;

import com.gocoding.noticeboard.dto.BoardDto;
import com.gocoding.noticeboard.entity.Board;
import com.gocoding.noticeboard.persistence.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    BoardRepository boardRepository;

    @Override
    public Board getBoard(Long id){
        return boardRepository.findById(id).orElse(null);
    }

    @Override
    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }

    @Override
    public void postBoard(BoardDto boardDto) {
        Board board = new Board();
        board.set(boardDto);

        boardRepository.save(board);
    }

    @Override
    public void putBoard(Board putBoard) {
        Board board = boardRepository.findById(putBoard.getId()).orElse(null);
        board.setName(putBoard.getName());

        boardRepository.save(board);
    }

    @Override
    public void deleteBoard(Board board) {
        boardRepository.deleteById(board.getId());
    }
}
