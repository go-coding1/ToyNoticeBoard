package com.gocoding.noticeboard.persistence;

import com.gocoding.noticeboard.entity.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    List<Board> findAll();
}
