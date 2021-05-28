package com.sms.server.converter;

import java.util.ArrayList;
import java.util.List;

import com.sms.server.entity.ScheduleMeeting;
import com.sms.server.entity.Sms;
import com.sms.server.entity.User;
import com.sms.server.model.ScheduleMeetingModel;
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
			smsModel.setUserId(sms.getUser() != null ? sms.getUser().getId() : null);
			smsModel.setUserUniqueId(sms.getUserUniqueId());
			smsModel.setMessage(sms.getMessage());
			smsModel.setMessageTime(sms.getMessageTime());
			smsModel.setCreatedDate(ChatSmsUtil.getStringDate(sms.getCreatedDate()));
		}
		return smsModel;
	}

	public static ScheduleMeetingModel getScheduleMeetingModelObject(ScheduleMeeting scheduleMeeting) {

		ScheduleMeetingModel scheduleMeetingModel = null;

		if (scheduleMeeting != null) {
			scheduleMeetingModel = new ScheduleMeetingModel();
			scheduleMeetingModel.setId(scheduleMeeting.getId());
			scheduleMeetingModel.setTopic(scheduleMeeting.getTopic());
			scheduleMeetingModel.setTopicDescription(scheduleMeeting.getTopicDescription());
			scheduleMeetingModel.setTopicDateTime(scheduleMeeting.getTopicDateTime());
			scheduleMeetingModel.setTopicDuration(scheduleMeeting.getTopicDuration());
		}
		return scheduleMeetingModel;
	}

	public static List<ScheduleMeetingModel> getScheduleMeetingModelListObject(
			List<ScheduleMeeting> scheduleMeetingList) {
		List<ScheduleMeetingModel> scheduleMeetingModelList = null;
		if (scheduleMeetingList != null && !scheduleMeetingList.isEmpty()) {
			scheduleMeetingModelList = new ArrayList<ScheduleMeetingModel>();
			for (ScheduleMeeting scheduleMeeting : scheduleMeetingList) {
				scheduleMeetingModelList.add(getScheduleMeetingModelObject(scheduleMeeting));
			}
		}
		return scheduleMeetingModelList;
	}

}
