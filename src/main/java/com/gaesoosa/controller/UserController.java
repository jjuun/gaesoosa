package com.gaesoosa.controller;

import com.gaesoosa.mapper.UserMapper;
import com.gaesoosa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserMapper userMapper;

	@RequestMapping(method=RequestMethod.GET)
	public List<User> getUsers() {
		return userMapper.selectList();
	}

	@RequestMapping(method=RequestMethod.GET, value="{id}")
	public User getUser(@PathVariable int id) {
		return userMapper.selectOne(id);
	}

	@RequestMapping(method=RequestMethod.POST)
	public User createUser(@ModelAttribute User user) {
		userMapper.insert(user);
		return getUser(user.getId());
	}

	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	public boolean deleteUser(@PathVariable int id)
	{
		userMapper.delete(id);
		return true;
	}

	@RequestMapping(method=RequestMethod.PUT, value="{id}")
	public User updateUser(@PathVariable int id, @ModelAttribute User user) {
		user.setId(id);
		User user1 = userMapper.selectOne(id);
		if(user1 == null ){
			return null;
		}
		userMapper.update(user);
		return user;
	}
}
