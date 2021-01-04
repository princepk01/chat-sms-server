package com.sms.server.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.server.business.SmsBusiness;
import com.sms.server.entity.Sms;
import com.sms.server.repository.SmsRepository;

@Service
public class SmsBusinessImpl implements SmsBusiness {

	@Autowired
	private SmsRepository smsRepository;
	
	@Override
	public Sms saveSms(Sms sms) {
		return smsRepository.save(sms);
	}

	@Override
	public List<Sms> getSmsByUserUniqueId(String userUniqueId) {
		return smsRepository.findByUserUniqueId(userUniqueId);
	}

}
