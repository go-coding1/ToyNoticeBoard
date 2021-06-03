package com.gocoding.noticeboard.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gocoding.noticeboard.dto.BoardDto;
import lombok.*;
import org.thymeleaf.util.StringUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Post> postList = new ArrayList<>();

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
