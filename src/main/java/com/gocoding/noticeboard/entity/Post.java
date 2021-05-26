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

    @Column(nullable = false, name = "post_title")
    private String title;   //제목

    @Column(nullable = false, length = 3000, name = "post_contnet")
    private String content; //내용

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "member_id" , nullable = false)
    private Member member;

    @ManyToOne(targetEntity = Board.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    //이 밑으로는 컬럼 아님
    @Transient
    @Override
    public String toString(){
        return "Post = [ id : " + this.id + " , title : " + this.title + " , content : " + this.content + " , createdDate : " + this.createdDate + " , modifiedDate : " + this.modifiedDate + "]";
    }

}
