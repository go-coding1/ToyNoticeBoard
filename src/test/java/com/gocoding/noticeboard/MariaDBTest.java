package com.gocoding.noticeboard;

import com.gocoding.noticeboard.entity.ROLE;
import com.gocoding.noticeboard.entity.User;
import com.gocoding.noticeboard.persistence.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MariaDBTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUserTest(){
        List<User> userList = new ArrayList<>();
        for(int i=1;i<=3;i++){
            User user = new User();
            user.setUser_id("user" + i);
            user.setUser_nickname("userNickname" + i);
            user.setUser_password("1111");
            user.setRole(ROLE.ROLE_USER);
            userList.add(user);
        }
        userRepository.saveAll(userList);
    }

    @Test
    public void addManangerTest(){
        List<User> managerList = new ArrayList<>();
        for(int i=1;i<=2;i++){
            User user = new User();
            user.setUser_id("manager" + i);
            user.setUser_nickname("managerNickname" + i);
            user.setUser_password("2222");
            user.setRole(ROLE.ROLE_MANAGER);
            managerList.add(user);
        }
        userRepository.saveAll(managerList);
    }

    @Test
    public void addAdminTest(){
            User user = new User();
            user.setUser_id("admin");
            user.setUser_nickname("adminNickname");
            user.setUser_password("3333");
            user.setRole(ROLE.ROLE_ADMIN);

            userRepository.save(user);

    }
}
