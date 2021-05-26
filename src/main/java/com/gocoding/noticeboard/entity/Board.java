package com.gocoding.noticeboard.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue
    @Column(name="board_id")
    private Long id;

    private String board_name;
}
