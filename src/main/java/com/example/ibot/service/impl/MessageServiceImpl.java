package com.example.ibot.service.impl;

import com.example.ibot.model.Message;
import com.example.ibot.repository.MessageRepository;
import com.example.ibot.service.MessageService;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.output.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class MessageServiceImpl implements MessageService {

    @Autowired
    ChatLanguageModel model;

    @Autowired
    MessageRepository messageRepository;

    @Transactional
    @Override
    public String chat(String botId, String userId, String sessionId, String input) {
        Message inputMessage = new Message();
        inputMessage.setGmtCreate(new Date());
        inputMessage.setBotId(botId);
        inputMessage.setUserId(userId);
        inputMessage.setSessionId(sessionId);
        inputMessage.setContent(input);
        String inputId = UUID.randomUUID().toString().replace("-", "");
        inputMessage.setId(inputId);
        messageRepository.save(inputMessage);
        Response<AiMessage> output = model.generate(Arrays.asList(UserMessage.from(input)));
        Message outPutMessage = new Message();
        outPutMessage.setGmtCreate(new Date());
        outPutMessage.setBotId(botId);
        outPutMessage.setUserId(userId);
        outPutMessage.setSessionId(sessionId);
        outPutMessage.setContent(output.content().text());
        outPutMessage.setSourceId(inputId);
        outPutMessage.setId(UUID.randomUUID().toString().replace("-", ""));
        messageRepository.save(outPutMessage);
        return output;
    }

    @Override
    public List<Message> getMessageHistoryList(String sessionId) {
        return messageRepository.findBySessionId(sessionId);
    }
}
