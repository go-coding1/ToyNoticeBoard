package com.gocoding.noticeboard.persistence;

import com.gocoding.noticeboard.entity.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
}
