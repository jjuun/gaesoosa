package com.gaesoosa.mapper;

import java.util.List;

import com.gaesoosa.model.User;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
public interface UserMapper {

	public List<User> selectList();

	public User selectOne(Long id);

	public void insert(User user);

	public void update(User user);

//	public User selectByUserName(@Param("userName") String userName);
//
//	public void update(User user);
//
//	public void delete(User user);
}