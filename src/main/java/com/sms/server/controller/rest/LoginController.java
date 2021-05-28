package com.sms.server.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.server.controller.BaseController;
import com.sms.server.controller.ResponseMessage;
import com.sms.server.model.LoginModel;
import com.sms.server.service.UserService;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin(value = "http://localhost:4200")
public class LoginController extends BaseController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/login-user")
	public ResponseEntity<?> loginUser(@RequestBody LoginModel loginModel) {
		ResponseMessage responseMessage = new ResponseMessage();
		if (loginModel != null) {
			String userName = loginModel.getUserName();
			String password = loginModel.getPassword();
			String loginUserUniqId = userService.loginUser(userName, password);
			responseMessage.setData(loginUserUniqId);
			responseMessage.setStatus(true);
		}
		return sendResponse(responseMessage);
	}
}
