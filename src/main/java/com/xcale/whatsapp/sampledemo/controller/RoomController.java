package com.xcale.whatsapp.sampledemo.controller;

import com.xcale.whatsapp.sampledemo.entity.Message;
import com.xcale.whatsapp.sampledemo.service.MessagingService;
import com.xcale.whatsapp.sampledemo.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class RoomController {
    @Autowired
    SimpMessagingTemplate template;

    @Autowired
    MessagingService messagingService;

    @MessageMapping("/message")
    @SendTo("/group/public")
    public Message sendMessage(@Payload Message message) {;
        messagingService.saveMessage(message);
        return message;
    }

    @MessageMapping("/peer-to-peer")
    public Message sendMessageP2P(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
        template.convertAndSendToUser(message.getReceiver(),"/private",message);
        messagingService.saveMessage(message);
        return message;
    }
}
