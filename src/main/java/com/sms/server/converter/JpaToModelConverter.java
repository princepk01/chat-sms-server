package com.sms.server.converter;

import java.util.ArrayList;
import java.util.List;

import com.sms.server.entity.Sms;
import com.sms.server.entity.User;
import com.sms.server.model.SmsModel;
import com.sms.server.model.UserModel;
import com.sms.server.util.ChatSmsUtil;

public class JpaToModelConverter {

	public static UserModel getUserModelObject(User user) {

		UserModel userModel = new UserModel();
		if (user != null) {
			userModel.setId(user.getId());
			userModel.setUserUniqueId(user.getUserUniqueId());
			userModel.setName(user.getName());
			userModel.setPassword(user.getPassword());
			userModel.setMobileNumber(user.getMobileNumber());
			userModel.setEmail(user.getEmail());
			userModel.setIsActive(user.getIsActive());
			userModel.setCreatedDate(user.getCreatedDate());
			userModel.setUpdatedDate(user.getUpdatedDate());
		}
		return userModel;
	}

	public static List<UserModel> getUserModelListObject(List<User> userList) {
		List<UserModel> userModelList = new ArrayList<UserModel>();
		if (userList != null && !userList.isEmpty()) {
			for (User user : userList) {
				userModelList.add(getUserModelObject(user));
			}
		}
		return userModelList;
	}

	public static List<SmsModel> getSmsModelListObject(List<Sms> smsList) {
		List<SmsModel> smsModelList = null;
		if (smsList != null && !smsList.isEmpty()) {
			smsModelList = new ArrayList<SmsModel>();
			for (Sms sms : smsList) {
				smsModelList.add(getSmsModelObject(sms));
			}
		}
		return smsModelList;
	}

	public static SmsModel getSmsModelObject(Sms sms) {

		SmsModel smsModel = null;
		if (sms != null) {
			smsModel = new SmsModel();
			smsModel.setId(sms.getId());
			smsModel.setUserId(sms.getUser() != null ? sms.getUser().getId():null);
			smsModel.setUserUniqueId(sms.getUserUniqueId());
			smsModel.setMessage(sms.getMessage());
			smsModel.setMessageTime(sms.getMessageTime());
			smsModel.setCreatedDate(ChatSmsUtil.getStringDate(sms.getCreatedDate()));
		}
		return smsModel;
	}

}
