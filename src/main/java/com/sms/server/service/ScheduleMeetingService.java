package com.sms.server.service;

import java.util.List;

import com.sms.server.entity.ScheduleMeeting;

/**
 * @author DEVELOPER
 *
 */
public interface ScheduleMeetingService {

	public ScheduleMeeting saveScheduleMeeting(ScheduleMeeting scheduleMeeting);

	public ScheduleMeeting getScheduleMeetingById(Integer scheduleMeetingId);

	public List<ScheduleMeeting> getAllScheduleMeeting();

	public Boolean deleteScheduleMeetingById(Integer scheduleMeetingId);

}
