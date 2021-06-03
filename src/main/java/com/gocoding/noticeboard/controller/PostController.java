package com.gocoding.noticeboard.controller;

import com.gocoding.noticeboard.entity.Board;
import com.gocoding.noticeboard.entity.Member;
import com.gocoding.noticeboard.entity.Post;
import com.gocoding.noticeboard.persistence.BoardRepository;
import com.gocoding.noticeboard.persistence.MemberRepository;
import com.gocoding.noticeboard.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    MemberRepository memberRepository;

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
        System.out.println(post.toString());
        return new ResponseEntity<Post>(post,HttpStatus.OK);
    }

    @PostMapping(value="/postPost")
    public ResponseEntity<String> postPost(Post post, HttpServletRequest request){
        System.out.println(post.toString());
        String member_id = request.getParameter("member_id");
        String board_id =  request.getParameter("board_id");
        Member member = memberRepository.findById(member_id).orElse(null);
        Board board = boardRepository.findById(Long.valueOf(board_id)).orElse(null);

        post.setBoard(board);
        post.setMember(member);

        postService.postPost(post);

        return new ResponseEntity<>("Posting!!", HttpStatus.OK);
    }

    //게시물 수정
    @PutMapping(value="/putPost")
    public ResponseEntity<String> putPost(Post post){
        postService.putPost(post);

        return new ResponseEntity<>("수정되었습니다.", HttpStatus.OK);
    }

    //게시글 삭제
    @DeleteMapping(value="/deletePost")
    public ResponseEntity<String> deletePost(Post post){
        postService.deletePost(post);

        return new ResponseEntity<>("게시글이 삭제되었습니다.", HttpStatus.OK);
    }
}
