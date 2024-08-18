package com.example.ibot.controller;

import com.example.ibot.model.Message;
import com.example.ibot.model.Result;
import com.example.ibot.request.ChatRequest;
import com.example.ibot.request.MessageHistoryListRequest;
import com.example.ibot.response.ChatResponse;
import com.example.ibot.response.MessageHistoryListResponse;
import com.example.ibot.service.MessageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/chat")
    Result<ChatResponse> chat(HttpServletRequest httpServletRequest,
                              @RequestBody ChatRequest request) {
        ChatResponse response = new ChatResponse();
        response.setContent(messageService.chat(request.getBotId(), request.getUserId(), request.getSessionId(), request.getContent()));
        return Result.buildSuccess(response);
    }

    @GetMapping("/listMessageHistory")
    Result<MessageHistoryListResponse> listMessageHistory(HttpServletRequest httpServletRequest,
                                                          @RequestBody MessageHistoryListRequest request) {
        MessageHistoryListResponse response = new MessageHistoryListResponse();
        List<Message> messages = messageService.getMessageHistoryList(request.getSessionId());
        response.setMessageList(messages);

        return Result.buildSuccess(response);
    }
}
