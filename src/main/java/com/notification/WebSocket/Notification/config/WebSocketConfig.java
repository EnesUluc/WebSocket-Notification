package com.notification.WebSocket.Notification.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // WebSocket connection is established only through this endpoint (Handshake)
        registry.addEndpoint("/ws") // WebSocket connection point -> Open the door
                .setAllowedOrigins("http://localhost:8080/") // Unauthorized origins cannot connect (Safety)
                .withSockJS();  // Fallback

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // Server → Client (Response/Broadcast)
        config.setApplicationDestinationPrefixes("/app"); // Client → Server (Request)
    }
}
