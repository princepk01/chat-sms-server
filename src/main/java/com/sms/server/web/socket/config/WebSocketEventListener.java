package com.sms.server.web.socket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.sms.server.web.socket.model.WebSocketChatMessage;

@Component
public class WebSocketEventListener {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent event) {
		System.out.println("Received a new web socket connection.");
	}
	
	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		String userName = (String)headerAccessor.getSessionAttributes().get("userName");
		if(userName != null) {
			WebSocketChatMessage chatMessage = new WebSocketChatMessage();
			chatMessage.setType(WebSocketChatMessage.MessageType.LEAVE);
			chatMessage.setSender(userName);
			
			messagingTemplate.convertAndSend("/topic/public", chatMessage);
		}
	}
}
