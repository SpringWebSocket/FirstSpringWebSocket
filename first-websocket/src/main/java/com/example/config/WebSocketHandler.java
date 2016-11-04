package com.example.config;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler{

	private static List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
			
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("Connection established: " + session);
		sessions.add(session);
		System.out.println("Connected clients: " + sessions.size());
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("onHandleTextMessage: " + message );
		
		//TODO: send message to connected clients
		for(WebSocketSession s: sessions){
			System.out.println("send to: " + s.getId());
			s.sendMessage(message);
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessions.remove(session);
		System.out.println("Connected clients: " + sessions.size());
	}
	
}
