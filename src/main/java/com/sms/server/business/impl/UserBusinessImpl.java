package com.sms.server.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.server.business.UserBusiness;
import com.sms.server.entity.User;
import com.sms.server.repository.UserRepository;

@Service
public class UserBusinessImpl implements UserBusiness{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Integer userId) {
		return userRepository.getOne(userId);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public boolean deleteUserById(Integer userId) {
		userRepository.deleteById(userId);
		return true;
	}

	@Override
	public User getUserByUserUniqueId(String userId) {
		return userRepository.findByUserUniqueId(userId);
	}

}
