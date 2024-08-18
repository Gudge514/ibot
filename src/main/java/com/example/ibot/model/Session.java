package com.example.ibot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "session")
public class Session {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "gmt_create")
    private Date gmtCreate;
}
