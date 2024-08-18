package com.example.ibot.request;

import lombok.Data;

@Data
public class ChatRequest {

    private String sessionId;
    private String userId;
    private String botId;
    private String content;

}
