package com.example.ibot.request;

import lombok.Data;

@Data
public class CreateSessionRequest {
    private String botId;
    private String userId;
}
