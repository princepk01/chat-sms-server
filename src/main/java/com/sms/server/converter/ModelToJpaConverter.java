package com.sms.server.converter;

import com.sms.server.entity.ScheduleMeeting;
import com.sms.server.entity.Sms;
import com.sms.server.entity.User;
import com.sms.server.model.ScheduleMeetingModel;
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
				String userId = ChatSmsUtil.getUniqueUserId();
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
			sms.setUser(ChatSmsUtil.getUserObject(smsModel.getUserId()));
		}
		return sms;
	}

	public static ScheduleMeeting getScheduleMeetingJpaObject(ScheduleMeetingModel scheduleMeetingModel) {

		ScheduleMeeting scheduleMeeting = null;

		if (scheduleMeetingModel != null) {
			scheduleMeeting = new ScheduleMeeting();
			scheduleMeeting.setId(scheduleMeetingModel.getId());
			scheduleMeeting.setMeetingUniqueId(scheduleMeetingModel.getMeetingUniqueId());
			scheduleMeeting.setScheduleMeetingUrl(scheduleMeetingModel.getScheduleMeetingUrl());
			scheduleMeeting.setUser(ChatSmsUtil.getUserObject(scheduleMeetingModel.getUserId()));
			scheduleMeeting.setTopic(scheduleMeetingModel.getTopic());
			scheduleMeeting.setTopicDescription(scheduleMeetingModel.getTopicDescription());
			scheduleMeeting.setTopicDateTime(scheduleMeetingModel.getTopicDateTime());
			scheduleMeeting.setTopicDuration(scheduleMeetingModel.getTopicDuration());
		}
		return scheduleMeeting;
	}

}
