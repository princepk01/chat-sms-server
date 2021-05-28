package com.sms.server.util;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.sms.server.entity.User;

public class ChatSmsUtil {

	public static String getUniqueUserId() {
		double random = Math.random();
		BigDecimal big = new BigDecimal(random * 10000000000l);
		long userId = big.longValue();
		return userId + "";
	}

	public static String getScheduleMeetingId() {
		double random = Math.random();
		BigDecimal big = new BigDecimal(random * 10000000000l);
		long userId = big.longValue();
		return userId + "";
	}

	public static User getUserObject(Integer id) {
		if(id != null && id != 0) {
			User user = new User();
			user.setId(id);
			return user;
		}
		return null;
	}

	public static String getMessageTime() {
		LocalDateTime now = LocalDateTime.now();
		int hour = now.getHour();
		int minute = now.getMinute();
		String messageTime = hour + ":" + minute;
		return messageTime;
	}

	public static String getStringDate(LocalDateTime localDateTime) {
		int year = localDateTime.getYear();
		int monthValue = localDateTime.getMonthValue();
		int dayOfMonth = localDateTime.getDayOfMonth();
		String date = dayOfMonth + ":" + monthValue + ":" + year;
		return date;
	}
	
	public static String getScheduleMeetingUrl(String meetingId, String userUniqueId) {
		
		return null;
	}
}
