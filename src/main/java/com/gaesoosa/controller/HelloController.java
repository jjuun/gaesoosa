package com.gaesoosa.controller;

import com.gaesoosa.mapper.UserMapper;
import com.gaesoosa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@RestController
public class HelloController {
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/")
	public HashMap<String, String> index() {
		HashMap<String, String> testmap = new HashMap<String, String>();
		testmap.put("gss", "new thing");
		testmap.put("jun", "jun thing");
		testmap.put("ave", "ave thing");

		return testmap;
	}

	@RequestMapping("/user/{id}")
	public User user(@PathVariable long id){
		User user = userMapper.selectOne(id);
		return user;
	}

	@RequestMapping("/users")
	public List<User> userList() {
		List<User> list = userMapper.selectList();

		return list;
	}

//	@RequestMapping("/users2")
//	public List<User> userList2() {
//		List<User> list = userMapper.selectList();
//
//		return list;
//	}
}
