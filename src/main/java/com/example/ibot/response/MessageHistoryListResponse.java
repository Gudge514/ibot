package com.example.ibot.response;

import com.example.ibot.model.Message;
import lombok.Data;

import java.util.List;

@Data
public class MessageHistoryListResponse {
    private List<Message> messageList;
}
