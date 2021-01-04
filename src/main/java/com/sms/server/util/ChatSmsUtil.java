package com.sms.server.util;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ChatSmsUtil {

	public static String getUserId() {
		double random = Math.random();
		BigDecimal big = new BigDecimal(random * 10000000000l);
		long userId = big.longValue();
		return userId + "";
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
}
