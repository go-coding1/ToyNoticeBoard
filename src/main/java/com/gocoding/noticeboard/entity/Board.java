package com.gocoding.noticeboard.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="board_id")
    private Long id;

    @Column(name="board_name")
    private String name;

    @Override
    public String toString(){
        return "Board = [ id : " + this.id + ", " + this.name + "]";
    }
}
