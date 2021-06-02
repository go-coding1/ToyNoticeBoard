package com.gocoding.noticeboard.controller;

import com.gocoding.noticeboard.entity.Board;
import com.gocoding.noticeboard.entity.Post;
import com.gocoding.noticeboard.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping(value="/getPost/{board_id}")
    public String getPost(@PathVariable Long board_id, Model model){
        List<Post> postList = postService.getPostList(board_id);

        for(Post post : postList){
            System.out.println(post.toString());
        }

        model.addAttribute("postList", postList);

        return "postList";
    }
}
