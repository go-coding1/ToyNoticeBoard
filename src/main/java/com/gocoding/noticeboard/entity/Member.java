package com.gocoding.noticeboard.entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.*;

@Entity
@Data
public class Member {
    @Id
    private String id;

    private String nickname;
    private String password;
    @Enumerated(EnumType.STRING)
    private ROLE role;
}
