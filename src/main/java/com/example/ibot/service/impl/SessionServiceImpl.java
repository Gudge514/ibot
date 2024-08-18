package com.example.ibot.service.impl;

import com.example.ibot.model.Session;
import com.example.ibot.repository.SessionRepository;
import com.example.ibot.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    SessionRepository sessionRepository;
    @Override
    public String createSession(String botId, String userId) {
        Session session = new Session();
        session.setId(UUID.randomUUID().toString().replace("-", ""));
        session.setBotId(botId);
        session.setUserId(userId);
        session.setGmtCreate(new Date());
        sessionRepository.save(session);
        return session.getId();
    }
}
