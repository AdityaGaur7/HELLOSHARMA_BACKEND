package com.ivegtech.iveg.service;

import com.ivegtech.iveg.entity.ChatMessage;
import com.ivegtech.iveg.repo.ChatMessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public ChatMessage saveMessage(ChatMessage message) {
        return chatMessageRepository.save(message);
    }

    public List<ChatMessage> getChatHistory(Long userId1, Long userId2) {
        return chatMessageRepository.findBySenderIdAndReceiverIdOrReceiverIdAndSenderIdOrderByTimestamp(
            userId1, userId2, userId1, userId2);
    }
} 