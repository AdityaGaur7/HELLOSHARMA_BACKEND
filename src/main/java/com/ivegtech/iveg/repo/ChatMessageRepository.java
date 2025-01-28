package com.ivegtech.iveg.repo;

import com.ivegtech.iveg.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findBySenderIdAndReceiverIdOrReceiverIdAndSenderIdOrderByTimestamp(
        Long senderId1, Long receiverId1, Long senderId2, Long receiverId2);
} 