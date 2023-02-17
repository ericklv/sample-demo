package com.xcale.whatsapp.sampledemo.listener;

import com.xcale.whatsapp.sampledemo.entity.Message;
import com.xcale.whatsapp.sampledemo.model.AttributeSession;
import com.xcale.whatsapp.sampledemo.service.MessagingService;
import com.xcale.whatsapp.sampledemo.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.sql.Date;
import java.time.Instant;
import java.util.Objects;

@Slf4j
@Component
public class SessionListener {

    @Autowired
    SimpMessagingTemplate template;

    @Autowired
    RoomService roomService;

    @Autowired
    MessagingService messagingService;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {

        roomService.addUserOnline();
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        org.springframework.messaging.Message<byte[]> message_= event.getMessage();
        AttributeSession attributeSession = getAttributesSession(message_);

        if (attributeSession.getUser() != null) {
            roomService.leftUserOnline();

            Message message = Message.builder()
                    .content(attributeSession.getUser() + " left group")
                    .sender("9999")
                    .date(Date.from(Instant.now()))
                    .build();

            messagingService.saveMessage(message);

            template.convertAndSend("/topic/public", message);
        }
    }

    private AttributeSession getAttributesSession(org.springframework.messaging.Message<byte[]> message) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(message);
        if(Objects.isNull(headerAccessor)) return null;

        log.info(headerAccessor.toString());
//        String user = headerAccessor.getSessionAttributes().get("username").toString();
        String user = "";

        return AttributeSession.builder()
                .user(user)
                .build();
    }
}
