package com.gocoding.noticeboard.security;

import com.gocoding.noticeboard.entity.Member;
import com.gocoding.noticeboard.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username" + username);
        Optional<Member> optionalMember = memberRepository.findById(username);
        if(!optionalMember.isPresent()) {
            System.out.println("실행1");
            throw new UsernameNotFoundException(username + " 사용자 없음");
        }else{
            System.out.println("실행2");
            Member member = optionalMember.get();
            return new SecurityUser(member);
        }
    }
}
