package com.sms.server;

import java.time.LocalDateTime;

public class Test {

	public static void main(String[] args) {

		LocalDateTime now = LocalDateTime.now();
		
		int year = now.getYear();
		int monthValue = now.getMonthValue();
		int dayOfMonth = now.getDayOfMonth();
		System.out.println("year : "+year);
		System.out.println("monthValue : "+monthValue);
		System.out.println("dayOfMonth : "+dayOfMonth);

	}

}
