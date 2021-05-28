package com.sms.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.server.business.UserBusiness;
import com.sms.server.entity.User;
import com.sms.server.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserBusiness userBusiness;

	@Override
	public User saveUser(User user) {
		return userBusiness.saveUser(user);
	}

	@Override
	public User getUserById(Integer id) {
		return userBusiness.getUserById(id);
	}

	@Override
	public List<User> getAllUser() {
		return userBusiness.getAllUser();
	}

	@Override
	public boolean deleteUserById(Integer userId) {
		return userBusiness.deleteUserById(userId);
	}

	@Override
	public User getUserByUserUniqueId(String userUniqueId) {
		return userBusiness.getUserByUserUniqueId(userUniqueId);
	}

	@Override
	public String loginUser(String userName, String password) {
		String userUniqueId = null;
		User user = userBusiness.getUserByMobileNumber(userName);
		if (user != null) {
			userUniqueId = validateLoginUser(user, userName, password);
		} else {
			user = userBusiness.getUserByEmail(userName);
			if (user != null) {
				userUniqueId = validateLoginUser(user, userName, password);
			}
		}
		return userUniqueId;
	}

	private String validateLoginUser(User user, String userName, String password) {
		String userUniqueId = null;

		if (userName.equalsIgnoreCase(user.getEmail()) && password.equalsIgnoreCase(user.getPassword())) {
			userUniqueId = user.getUserUniqueId();
		} else if (userName.equalsIgnoreCase(user.getMobileNumber()) && password.equalsIgnoreCase(user.getPassword())) {
			userUniqueId = user.getUserUniqueId();
		}
		return userUniqueId;
	}
}
