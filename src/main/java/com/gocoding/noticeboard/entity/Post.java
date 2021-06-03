package com.gocoding.noticeboard.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
* 게시글*/
@Entity
@Data
public class Post extends TimeEntity{
    @Id
    @GeneratedValue
    @Column(name="post_id")
    private Long id;

    @Column(nullable = false, name = "post_title")
    private String title;   //제목

    @Column(nullable = false, length = 3000, name = "post_content")
    private String content; //내용

    @JsonBackReference
    @ManyToOne(targetEntity = Member.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "member_id" , nullable = false)
    private Member member;

    @JsonBackReference
    @ManyToOne(targetEntity = Board.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    //이 밑으로는 컬럼 아님
    @JsonManagedReference
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();


    @Transient
    @Override
    public String toString(){
        return "Post = [ id : " + this.id + " , title : " + this.title + " , content : " + this.content +  "]";
    }

}
