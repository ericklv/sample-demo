package com.xcale.whatsapp.sampledemo.entity;

import com.xcale.whatsapp.sampledemo.utils.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MESSAGES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "SENDER")
    private String sender;

    @Column(name = "RECEIVER")
    private String receiver;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "ROOM")
    private String room;

    @Column(name = "TYPE")
    private MessageType type;
}
