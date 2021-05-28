package com.sms.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.server.business.ScheduleMeetingBusiness;
import com.sms.server.entity.ScheduleMeeting;
import com.sms.server.service.ScheduleMeetingService;
import com.sms.server.util.ChatSmsUtil;

@Service
public class ScheduleMeetingServiceImpl implements ScheduleMeetingService {

	@Autowired
	private ScheduleMeetingBusiness scheduleMeetingBusiness;

	@Override
	public ScheduleMeeting saveScheduleMeeting(ScheduleMeeting scheduleMeeting) {
		String meetingUniqueId = scheduleMeeting.getMeetingUniqueId();
		if(meetingUniqueId == null || meetingUniqueId.isEmpty()) {
			meetingUniqueId = ChatSmsUtil.getScheduleMeetingId();
			scheduleMeeting.setMeetingUniqueId(meetingUniqueId);
		}
		ScheduleMeeting saveScheduleMeeting = scheduleMeetingBusiness.saveScheduleMeeting(scheduleMeeting);
		ChatSmsUtil.getScheduleMeetingUrl(saveScheduleMeeting.getMeetingUniqueId(), saveScheduleMeeting.getUserUniqueId());
		return scheduleMeetingBusiness.saveScheduleMeeting(scheduleMeeting);
	}

	@Override
	public ScheduleMeeting getScheduleMeetingById(Integer scheduleMeetingId) {
		return scheduleMeetingBusiness.getScheduleMeetingById(scheduleMeetingId);
	}

	@Override
	public List<ScheduleMeeting> getAllScheduleMeeting() {
		return scheduleMeetingBusiness.getAllScheduleMeeting();
	}

	@Override
	public Boolean deleteScheduleMeetingById(Integer scheduleMeetingId) {
		return scheduleMeetingBusiness.deleteScheduleMeetingById(scheduleMeetingId);
	}

}
