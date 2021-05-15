package com.gocoding.noticeboard.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String user_id;
    private String user_nickname;
    private String user_password;
    private ROLE role;
}
