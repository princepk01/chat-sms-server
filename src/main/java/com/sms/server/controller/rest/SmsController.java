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

import com.sms.server.controller.BaseController;
import com.sms.server.controller.ResponseMessage;
import com.sms.server.converter.JpaToModelConverter;
import com.sms.server.converter.ModelToJpaConverter;
import com.sms.server.entity.Sms;
import com.sms.server.model.SmsModel;
import com.sms.server.service.SmsService;

@RestController
@RequestMapping(value = "/sms")
@CrossOrigin(value = "http://localhost:4200")
public class SmsController extends BaseController {

	@Autowired
	private SmsService smsService;

	@PostMapping(value = "/save-sms")
	public ResponseEntity<?> saveSms(@RequestBody SmsModel smsModel) {
		ResponseMessage responseMessage = new ResponseMessage();
		Sms sms = ModelToJpaConverter.getSmsJpaObject(smsModel);
		if (sms != null) {
			smsService.saveSms(sms);
			responseMessage.setStatus(true);
		}
		return sendResponse(responseMessage);
	}
	
	@GetMapping(value = "/get-sms-by-user-unique-id/{userUniqueId}")
	public ResponseEntity<?> getSmsByUserUniqueId(@PathVariable(value = "userUniqueId") String userUniqueId) {
		ResponseMessage responseMessage = new ResponseMessage();
		if (userUniqueId != null && !userUniqueId.isEmpty()) {
			List<Sms> smsList = smsService.getSmsByUserUniqueId(userUniqueId);
			List<SmsModel> smsModel = JpaToModelConverter.getSmsModelListObject(smsList);
			responseMessage.setData(smsModel);
			responseMessage.setStatus(true);
		}
		return sendResponse(responseMessage);
	}
}
