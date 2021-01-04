package com.sms.server.converter;

import com.sms.server.entity.Sms;
import com.sms.server.entity.User;
import com.sms.server.model.SmsModel;
import com.sms.server.model.UserModel;
import com.sms.server.util.ChatSmsUtil;

public class ModelToJpaConverter {

	public static User getUserJpaObject(UserModel userModel) {
		User user = null;
		if (userModel != null) {
			user = new User();
			user.setId(userModel.getId());
			if (user.getId() == null || user.getId() == 0) {
				String userId = ChatSmsUtil.getUserId();
				user.setUserUniqueId(userId);
			} else {
				user.setUserUniqueId(userModel.getUserUniqueId());
			}
			user.setName(userModel.getName());
			user.setPassword(userModel.getPassword());
			user.setMobileNumber(userModel.getMobileNumber());
			user.setEmail(userModel.getEmail());
			user.setIsActive(userModel.getIsActive() == null ? true : false);
			user.setCreatedDate(userModel.getCreatedDate());
			user.setUpdatedDate(userModel.getUpdatedDate());
		}
		return user;
	}

	public static Sms getSmsJpaObject(SmsModel smsModel) {
		Sms sms = null;
		if (smsModel != null) {
			sms = new Sms();
			sms.setId(smsModel.getId());
			sms.setUserUniqueId(smsModel.getUserUniqueId());
			sms.setMessage(smsModel.getMessage());
			sms.setMessageTime(ChatSmsUtil.getMessageTime());
			User user = new User();
			user.setId(smsModel.getUserId());
			sms.setUser(user);
		}
		return sms;
	}

}
