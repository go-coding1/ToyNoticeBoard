package com.gocoding.noticeboard.service;

import com.gocoding.noticeboard.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getPostList(Long board_id);

    Post getPost(Long post_id);

    void postPost(Post post);
}
