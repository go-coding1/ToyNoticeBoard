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

    @Column(name="board_name")
    private String name;

    @Override
    public String toString(){
        return "Board = [ id : " + this.id + ", " + this.name + "]";
    }
}
