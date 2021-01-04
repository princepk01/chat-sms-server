package com.sms.server.service;

import java.util.List;

import com.sms.server.entity.User;

public interface UserService {

	public User saveUser(User user);

	public User getUserById(Integer userId);

	public List<User> getAllUser();

	public boolean deleteUserById(Integer id);

	public User getUserByUserUniqueId(String userUniqueId);
}
