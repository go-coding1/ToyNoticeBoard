package com.gocoding.noticeboard.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/*
* 게시글*/
@Entity
@Data
public class Post {
    @Id
    @GeneratedValue
    @Column(name="post_id")
    private Long id;

    @Column(nullable = false)
    private String title;   //제목

    @Column(nullable = false)
    private String content; //내용

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(targetEntity = Board.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "board_id")
    private Board board;
}
