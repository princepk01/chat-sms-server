package com.sms.server.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "SCHEDULE_MEETING")
public class ScheduleMeeting {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "MEETING_UNIQUE_ID")
	private String meetingUniqueId;

	@Column(name = "TOPIC")
	private String topic;

	@Column(name = "TOPIC_DESCRIPTION")
	private String topicDescription;

	@Column(name = "TOPIC_DATE_TIME")
	private String topicDateTime;

	@Column(name = "TOPIC_DURATION")
	private String topicDuration;

	@CreationTimestamp
	@Column(name = "CREATED_DATE", updatable = false)
	private LocalDateTime createdDate;

	@CreationTimestamp
	@Column(name = "UPDATED_DATE", insertable = true, updatable = true)
	private LocalDateTime updatedDate;

	@Column(name = "USER_UNIQUE_ID")
	private String userUniqueId;

	@Column(name = "SCHEDULE_MEETING_URL")
	private String scheduleMeetingUrl;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

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

	public String getUserUniqueId() {
		return userUniqueId;
	}

	public void setUserUniqueId(String userUniqueId) {
		this.userUniqueId = userUniqueId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
