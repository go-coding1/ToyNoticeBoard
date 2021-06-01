package com.gocoding.noticeboard;

import com.gocoding.noticeboard.dto.BoardDto;
import com.gocoding.noticeboard.persistence.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@Transactional
@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    void postBoard() throws Exception{

    }
}
