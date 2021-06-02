package com.gocoding.noticeboard.service;

import com.gocoding.noticeboard.entity.Post;
import com.gocoding.noticeboard.persistence.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> getPostList(Long board_id) {
        return postRepository.findAllByBoardId(board_id);
    }
}
