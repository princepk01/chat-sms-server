package com.sms.server.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.server.constant.MessageApiConstant;
import com.sms.server.controller.BaseController;
import com.sms.server.controller.ResponseMessage;
import com.sms.server.converter.JpaToModelConverter;
import com.sms.server.converter.ModelToJpaConverter;
import com.sms.server.entity.ScheduleMeeting;
import com.sms.server.model.ScheduleMeetingModel;
import com.sms.server.service.ScheduleMeetingService;

@RestController
@RequestMapping(value = "/schedule-meeting")
@CrossOrigin(value = "http://localhost:4200")
public class ScheduleMeetingController extends BaseController {

	@Autowired
	private ScheduleMeetingService scheduleMeetingService;

	@PostMapping(value = "/save-schedule-meeting")
	public ResponseEntity<?> saveScheduleMeeting(@RequestBody ScheduleMeetingModel scheduleMeetingModel) {
		ResponseMessage responseMessage = new ResponseMessage();
		ScheduleMeeting scheduleMeeting = ModelToJpaConverter.getScheduleMeetingJpaObject(scheduleMeetingModel);
		scheduleMeetingService.saveScheduleMeeting(scheduleMeeting);
		if (scheduleMeetingModel.getId() == 0) {
			responseMessage.setMessage(MessageApiConstant.SAVED_SCHEDULE_MEETING);
		} else {
			responseMessage.setMessage(MessageApiConstant.UPDATED_SCHEDULE_MEETING);
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/get-schedule-meeting-by-id/{id}")
	public ResponseEntity<?> getScheduleMeetingById(@PathVariable(value = "id") Integer id) {
		ResponseMessage responseMessage = new ResponseMessage();
		if (id != null && id != 0) {
			ScheduleMeeting scheduleMeeting = scheduleMeetingService.getScheduleMeetingById(id);
			ScheduleMeetingModel scheduleMeetingModel = JpaToModelConverter
					.getScheduleMeetingModelObject(scheduleMeeting);
			responseMessage.setData(scheduleMeetingModel);
			responseMessage.setStatus(true);
		}
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/get-all-schedule-meeting")
	public ResponseEntity<?> getAllScheduleMeeting() {
		ResponseMessage responseMessage = new ResponseMessage();
		List<ScheduleMeeting> scheduleMeetingList = scheduleMeetingService.getAllScheduleMeeting();
		List<ScheduleMeetingModel> scheduleMeetingModelList = JpaToModelConverter
				.getScheduleMeetingModelListObject(scheduleMeetingList);
		responseMessage.setData(scheduleMeetingModelList);
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/delete-schedule-meeting-by-id/{id}")
	public ResponseEntity<?> deleteScheduleMeetingById(@PathVariable(value = "id") Integer id) {
		ResponseMessage responseMessage = new ResponseMessage();
		if (id != null && id != 0) {
			boolean isDeleted = scheduleMeetingService.deleteScheduleMeetingById(id);
			responseMessage.setStatus(isDeleted);
			responseMessage.setMessage(MessageApiConstant.DELETED_SCHEDULE_MEETING);
		}
		return sendResponse(responseMessage);
	}
}
