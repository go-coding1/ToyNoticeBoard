package com.gocoding.noticeboard.controller;

import com.gocoding.noticeboard.entity.Board;
import com.gocoding.noticeboard.entity.Post;
import com.gocoding.noticeboard.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping(value="/getPostList/{board_id}")
    public ResponseEntity<List<Post>> getPostList(@PathVariable Long board_id){
        List<Post> postList = postService.getPostList(board_id);

        for(Post post : postList){
            System.out.println(post.toString());
        }
        return new ResponseEntity<List<Post>>(postList, HttpStatus.OK);
    }

    @GetMapping(value="/getPost/{post_id}")
    public ResponseEntity<Post> getPost(@PathVariable Long post_id){
        Post post = postService.getPost(post_id);
        return new ResponseEntity<Post>(post,HttpStatus.OK);
    }

    @PostMapping(value="/postPost")
    public ResponseEntity<String> postPost(Post post){
        postService.postPost(post);

        return new ResponseEntity<>("Posting!!", HttpStatus.OK);
    }
}
