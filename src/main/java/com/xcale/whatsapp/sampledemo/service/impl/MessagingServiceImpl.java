package com.xcale.whatsapp.sampledemo.service.impl;

import com.xcale.whatsapp.sampledemo.entity.Message;
import com.xcale.whatsapp.sampledemo.repository.MessageRepository;
import com.xcale.whatsapp.sampledemo.service.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagingServiceImpl implements MessagingService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }
}
