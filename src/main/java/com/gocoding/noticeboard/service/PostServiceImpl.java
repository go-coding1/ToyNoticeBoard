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

    @Override
    public Post getPost(Long post_id) {
        return postRepository.findById(post_id).orElse(null);
    }

    @Override
    public void postPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void putPost(Post postPost) {
        Post post = postRepository.findById(postPost.getId()).orElse(null);
        post.setTitle(postPost.getTitle());
        post.setContent(post.getContent());

        postRepository.save(post);
    }

    @Override
    public void deletePost(Post post) {
        postRepository.deleteById(post.getId());
    }

}
