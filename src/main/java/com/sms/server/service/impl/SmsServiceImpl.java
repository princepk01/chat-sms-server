package com.sms.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.server.business.SmsBusiness;
import com.sms.server.entity.Sms;
import com.sms.server.service.SmsService;

@Service
public class SmsServiceImpl implements SmsService{

	@Autowired
	private SmsBusiness smsBusiness;
	
	@Override
	public Sms saveSms(Sms sms) {
		return smsBusiness.saveSms(sms);
	}

	@Override
	public List<Sms> getSmsByUserUniqueId(String userUniqueId) {
		return smsBusiness.getSmsByUserUniqueId(userUniqueId);
	}

}
