package com.gocoding.noticeboard.service;

import com.gocoding.noticeboard.entity.Member;

public interface MemberService {
    Member getMember(Member member);
    void setMember(Member member);
}
