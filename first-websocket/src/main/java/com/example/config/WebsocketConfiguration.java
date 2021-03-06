package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebsocketConfiguration implements WebSocketConfigurer{

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(webSocketHandler(), "/question");	
		registry.addHandler(answerHandler(), "/answer");
	}

	@Bean
	public WebSocketHandler webSocketHandler(){
		return new WebSocketHandler();
	}
	
	@Bean 
	public AnswerHandler answerHandler(){
		return new AnswerHandler();
	}
	
}
