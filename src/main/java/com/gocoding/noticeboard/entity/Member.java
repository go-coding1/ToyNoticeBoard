package com.gocoding.noticeboard.entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Member {
    @Id
    private String id;

    private String nickname;
    private String password;
    private ROLE role;
}
