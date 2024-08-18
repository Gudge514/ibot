package com.example.ibot.model;

import com.example.ibot.enums.MessageIoTypeEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "message")
public class Message {

    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "bot_id")
    private String botId;

    @Basic
    @Column(name = "user_id")
    private String userId;

    @Basic
    @Column(name = "session_id")
    private String sessionId;

    @Basic
    @Column(name = "content")
    private String content;

    @Basic
    @Column(name = "source_id")
    private String sourceId;

    @Basic
    @Column(name = "io_type")
    private MessageIoTypeEnum ioType;

    @Basic
    @Column(name = "sequence")
    private Long sequence;

    @Basic
    @Column(name = "gmt_create")
    private Date gmtCreate;
}
