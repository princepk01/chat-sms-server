package com.sms.server.business;

import java.util.List;

import com.sms.server.entity.Sms;

public interface SmsBusiness {
	
	public Sms saveSms(Sms sms);

	public List<Sms> getSmsByUserUniqueId(String userUniqueId);
}
