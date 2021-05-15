package com.gocoding.noticeboard.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue
    private Long id;

}
