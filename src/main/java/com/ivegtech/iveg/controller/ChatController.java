package com.ivegtech.iveg.controller;

import com.ivegtech.iveg.entity.ChatMessage;
import com.ivegtech.iveg.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatService chatService;

    @MessageMapping("/private-message")
    public void handlePrivateMessage(@Payload ChatMessage message) {
        ChatMessage savedMessage = chatService.saveMessage(message);
        messagingTemplate.convertAndSendToUser(
            message.getReceiver().getId().toString(),
            "/chat/private",
            savedMessage
        );
    }

    @GetMapping("/messages/{userId1}/{userId2}")
    public List<ChatMessage> getChatHistory(@PathVariable Long userId1, @PathVariable Long userId2) {
        return chatService.getChatHistory(userId1, userId2);
    }
} 