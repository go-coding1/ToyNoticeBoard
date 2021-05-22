package com.gocoding.noticeboard.security;


import com.gocoding.noticeboard.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;

public class SecurityUser extends User {
    private static final long serialVersionUID = 1L;

    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public SecurityUser(Member member) {
        super(member.getId(), member.getPassword(),
                AuthorityUtils.createAuthorityList(member.getRole().toString()));
    }
}
