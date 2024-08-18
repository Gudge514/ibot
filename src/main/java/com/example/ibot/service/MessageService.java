package com.example.ibot.service;

import com.example.ibot.model.Message;

import java.util.List;

public interface MessageService {

    public String chat(String botId, String userId, String sessionId, String input);

    public List<Message> getMessageHistoryList(String sessionId);
}
