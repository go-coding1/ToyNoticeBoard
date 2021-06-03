package com.gocoding.noticeboard.entity;
//댓글 엔티티

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Comment extends TimeEntity{
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false, name="comment_parentId")
    private Long parentId=0L;

    @Column(name="comment_content")
    private String content;

    @JsonBackReference
    @ManyToOne(targetEntity = Member.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    @JsonBackReference
    @ManyToOne(targetEntity = Post.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "post_id")
    private Post post;

    @Override
    public String toString(){
        return "Comment = [ id : " + this.id + " , parentId : " + this.parentId + " , content : " + this.content +  "]";
    }
}
