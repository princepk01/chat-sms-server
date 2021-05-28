package com.sms.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.server.entity.ScheduleMeeting;

public interface ScheduleMeetingRepository extends JpaRepository<ScheduleMeeting, Integer> {

}
