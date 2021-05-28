package com.sms.server.business;

import java.util.List;

import com.sms.server.entity.ScheduleMeeting;

public interface ScheduleMeetingBusiness {

	public ScheduleMeeting saveScheduleMeeting(ScheduleMeeting scheduleMeeting);

	public ScheduleMeeting getScheduleMeetingById(Integer scheduleMeetingId);

	public List<ScheduleMeeting> getAllScheduleMeeting();

	public Boolean deleteScheduleMeetingById(Integer scheduleMeetingId);
}
