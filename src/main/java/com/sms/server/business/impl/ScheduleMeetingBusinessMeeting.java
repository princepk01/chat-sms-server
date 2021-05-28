package com.sms.server.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.server.business.ScheduleMeetingBusiness;
import com.sms.server.entity.ScheduleMeeting;
import com.sms.server.repository.ScheduleMeetingRepository;

@Service
public class ScheduleMeetingBusinessMeeting implements ScheduleMeetingBusiness {

	@Autowired
	private ScheduleMeetingRepository scheduleMeetingRepository;

	@Override
	public ScheduleMeeting saveScheduleMeeting(ScheduleMeeting scheduleMeeting) {
		return scheduleMeetingRepository.save(scheduleMeeting);
	}

	@Override
	public ScheduleMeeting getScheduleMeetingById(Integer scheduleMeetingId) {
		return scheduleMeetingRepository.getOne(scheduleMeetingId);
	}

	@Override
	public List<ScheduleMeeting> getAllScheduleMeeting() {
		return scheduleMeetingRepository.findAll();
	}

	@Override
	public Boolean deleteScheduleMeetingById(Integer scheduleMeetingId) {
		scheduleMeetingRepository.deleteById(scheduleMeetingId);
		return true;
	}

}
