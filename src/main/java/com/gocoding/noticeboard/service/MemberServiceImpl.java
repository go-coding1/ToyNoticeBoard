package com.gocoding.noticeboard.service;

import com.gocoding.noticeboard.entity.Member;
import com.gocoding.noticeboard.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member getMember(Member member) {
        Optional<Member> memberOptional = memberRepository.findById(member.getId());
        if(!memberOptional.isPresent()){
            throw new UsernameNotFoundException(member.getId() + "not found");
        }else {
            return memberOptional.get();
        }
    }
}
