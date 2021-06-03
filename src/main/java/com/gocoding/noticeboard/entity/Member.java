package com.gocoding.noticeboard.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Member {
    @Id
    @Column(name = "member_id")
    private String id;

    private String nickname;
    private String password;

    @Enumerated(EnumType.STRING)
    private ROLE role;

    @JsonManagedReference
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Post> postList = new ArrayList<>();

    @Override
    public String toString(){
        return "Member = [ id : " + id + " nickname : " + nickname + " password : " + password + " ROLE : " + role + "]";
    }

}

