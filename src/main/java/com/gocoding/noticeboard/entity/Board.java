package com.gocoding.noticeboard.entity;

import com.gocoding.noticeboard.dto.BoardDto;
import lombok.*;
import org.thymeleaf.util.StringUtils;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="board_id")
    private Long id;

    @Column(name="board_name")
    private String name;

    @Override
    public String toString(){
        return "Board = [ id : " + this.id + ", name : " + this.name + "]";
    }

    public void set(BoardDto boardDto){
        if(!StringUtils.isEmpty(boardDto.getName())){
            this.setName(boardDto.getName());
        }
    }
}
