package com.example.ibot.request;

import lombok.Data;

@Data
public class MessageHistoryListRequest {
    private String botId;
    private String userId;
    private String sessionId;
}
