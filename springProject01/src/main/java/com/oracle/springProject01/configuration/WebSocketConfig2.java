package com.oracle.springProject01.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.oracle.springProject01.service.handler.SocketHandler;


@Configuration
@EnableWebSocket
public class WebSocketConfig2 implements WebSocketConfigurer {
	
	 @Autowired 
	SocketHandler socketHandler;
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(socketHandler, "/chating2");
	}

}
