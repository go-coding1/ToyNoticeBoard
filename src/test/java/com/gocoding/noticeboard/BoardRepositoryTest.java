package com.gocoding.noticeboard;

import com.gocoding.noticeboard.dto.BoardDto;
import com.gocoding.noticeboard.entity.Board;
import com.gocoding.noticeboard.persistence.BoardRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;

@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void saveBoardTest(){
        Board board = new Board(null,"추천 게시판");
        Board savedBoard = boardRepository.save(board);
        Assertions.assertEquals(board.getName(),savedBoard.getName());
    }

    @Test
    public void deleteBoardTest(){
        boardRepository.deleteById(3L);

        Optional<Board> deletedBaord = boardRepository.findById(3L);
        Assertions.assertEquals(deletedBaord.isPresent(), false);
    }
}
