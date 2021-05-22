package com.gocoding.noticeboard;

import com.gocoding.noticeboard.entity.ROLE;
import com.gocoding.noticeboard.entity.Member;
import com.gocoding.noticeboard.persistence.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MariaDBTest {

    @Autowired
    private MemberRepository memberRepository;

    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();;

    @Test
    public void passwordEncoderTest(){

        System.out.println(passwordEncoder.encode("1111"));
        String encodePass = passwordEncoder.encode("1111");
        System.out.println(passwordEncoder.matches("1111",encodePass));
    }

    @Test
    public void addUserTest(){
        List<Member> memberList = new ArrayList<>();
        for(int i=1;i<=3;i++){
            Member member = new Member();
            member.setId("user" + i);
            member.setNickname("userNickname" + i);
            member.setPassword(passwordEncoder.encode("1111"));
            member.setRole(ROLE.ROLE_USER);
            memberList.add(member);
        }
        memberRepository.saveAll(memberList);
    }

    @Test
    public void addManangerTest(){
        List<Member> managerList = new ArrayList<>();
        for(int i=1;i<=2;i++){
            Member member = new Member();
            member.setId("manager" + i);
            member.setNickname("managerNickname" + i);
            member.setPassword(passwordEncoder.encode("2222"));
            member.setRole(ROLE.ROLE_MANAGER);
            managerList.add(member);
        }
        memberRepository.saveAll(managerList);
    }

    @Test
    public void addAdminTest(){
            Member member = new Member();
            member.setId("admin");
            member.setNickname("adminNickname");
            member.setPassword(passwordEncoder.encode("3333"));
            member.setRole(ROLE.ROLE_ADMIN);

            memberRepository.save(member);

    }

    @Test
    public void checkMember(){
        Optional<Member> member = memberRepository.findById("user1");
        if(member.isPresent()){
            System.out.println(member.get().getNickname());
        }else{
            System.out.println("Cant found member");
        }
    }
}
