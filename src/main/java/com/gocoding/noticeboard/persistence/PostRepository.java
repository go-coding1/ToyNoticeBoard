package com.gocoding.noticeboard.persistence;

import com.gocoding.noticeboard.entity.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findAllByBoardId(Long board_id);
}
