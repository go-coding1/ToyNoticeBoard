package com.gocoding.noticeboard.entity;
//댓글 엔티티


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
}
