package com.sms.server.model;

import java.time.LocalDateTime;

public class ScheduleMeetingModel {

	private Integer id;
	private String topic;
	private String topicDescription;
	private String topicDateTime;
	private String topicDuration;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private Integer userId;
	private String userUniqueId;
	private String meetingUniqueId;
	private String scheduleMeetingUrl;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTopicDescription() {
		return topicDescription;
	}

	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}

	public String getTopicDateTime() {
		return topicDateTime;
	}

	public void setTopicDateTime(String topicDateTime) {
		this.topicDateTime = topicDateTime;
	}

	public String getTopicDuration() {
		return topicDuration;
	}

	public void setTopicDuration(String topicDuration) {
		this.topicDuration = topicDuration;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserUniqueId() {
		return userUniqueId;
	}

	public void setUserUniqueId(String userUniqueId) {
		this.userUniqueId = userUniqueId;
	}

	public String getMeetingUniqueId() {
		return meetingUniqueId;
	}

	public void setMeetingUniqueId(String meetingUniqueId) {
		this.meetingUniqueId = meetingUniqueId;
	}

	public String getScheduleMeetingUrl() {
		return scheduleMeetingUrl;
	}

	public void setScheduleMeetingUrl(String scheduleMeetingUrl) {
		this.scheduleMeetingUrl = scheduleMeetingUrl;
	}

}
