package com.gocoding.noticeboard.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Test {
    @Id
    private long id;
    private String test;
}
