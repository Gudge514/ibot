package com.example.ibot.controller;

import com.example.ibot.model.Result;
import com.example.ibot.request.CreateSessionRequest;
import com.example.ibot.response.CreateSessionResponse;
import com.example.ibot.service.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/session")
public class SessionController {

    @Autowired
    SessionService sessionService;

    @PostMapping("/create")
    public Result<CreateSessionResponse> createSession(HttpServletRequest httpServletRequest,
                                                       @RequestBody CreateSessionRequest request) {
        String sessionId = sessionService.createSession(request.getBotId(), request.getUserId());

        CreateSessionResponse response = new CreateSessionResponse();
        response.setSessionId(sessionId);
        return Result.buildSuccess(response);
    }

}
