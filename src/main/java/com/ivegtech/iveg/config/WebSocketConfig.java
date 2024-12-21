package com.ivegtech.iveg.config;

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
        // This endpoint will be used by clients to connect to the WebSocket server
    	registry.addEndpoint("/chat-websocket-native")
        .setAllowedOrigins("*");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Messages with destination starting with /app will be routed to message-handling methods
        registry.setApplicationDestinationPrefixes("/app");
        // Enable a simple memory-based message broker to send messages to clients
        // on destinations prefixed with /topic
        registry.enableSimpleBroker("/topic");
    }
}
