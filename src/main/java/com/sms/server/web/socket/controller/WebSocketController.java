package com.sms.server.web.socket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.sms.server.web.socket.model.WebSocketChatMessage;

@RestController
@CrossOrigin(value = "http://localhost:4200")
public class WebSocketController {

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public WebSocketChatMessage sendMessage(@Payload WebSocketChatMessage webSocketChatMessage) {
		System.out.println("chatmessage==> : "+webSocketChatMessage.getContent());
		return webSocketChatMessage;
	}
	
	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public WebSocketChatMessage addUser(@Payload
			WebSocketChatMessage webSocketChatMessage, 
			SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("userName", webSocketChatMessage.getSender());
		System.out.println("new message ==> : "+webSocketChatMessage.getContent());
		return webSocketChatMessage;
	}
}
