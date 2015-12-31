package com.gaesoosa;

import com.gaesoosa.mapper.UserMapper;
import com.gaesoosa.model.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by jujeong on 2015. 12. 14..
 */
@Transactional
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GaesoosaApplication.class)
@WebAppConfiguration
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    private User user;
    @Before
    public void setUp() {
    }

    @Ignore
    public void selectUsers() {
        List<User> users = userMapper.selectList();

        assertThat("user count equal", users.size() == 3);
    }

    @Test
    public void insertUser() {
        user = new User();
        user.setNickname("정재욱");
        user.setAddress("서울");
        user.setProfileImage(null);
        user.setAccessKey(null);

        System.out.println("insert start");
        System.out.println("nickname" + user.getNickname());
        userMapper.insert(user);
        System.out.println("insert after");

//		assertThat("success", selectUser());
    }

    @Ignore
    public void updateUser(){
        user = new User();
        user.setNickname("jun_update");
        user.setAddress("sungnam");
        user.setProfileImage("http://www.daum.net");
        user.setAccessKey(null);
        user.setId(10);

        userMapper.update(user);
    }
}