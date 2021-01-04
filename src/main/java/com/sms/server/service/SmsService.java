package com.sms.server.service;

import java.util.List;

import com.sms.server.entity.Sms;

public interface SmsService {

	public Sms saveSms(Sms sms);
	
	public List<Sms> getSmsByUserUniqueId(String userUniqueId);
}
