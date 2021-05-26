package com.gocoding.noticeboard.entity;
//댓글 엔티티


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false, columnDefinition = "default 0", name="comment_parentId")
    private Long parentId;

    @Column(name="comment_content")
    private String content;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @ManyToOne(targetEntity = Member.class, optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(targetEntity = Post.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "post_id")
    private Post post;
}
