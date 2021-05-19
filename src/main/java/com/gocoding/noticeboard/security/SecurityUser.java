package com.gocoding.noticeboard.security;


import com.gocoding.noticeboard.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class SecurityUser extends User {
    private static final long serialVersionUID = 1L;

    public SecurityUser(Member member) {
        super(member.getId(), "{noop}" + member.getPassword(),
                AuthorityUtils.createAuthorityList(member.getRole().toString()));
    }
}
