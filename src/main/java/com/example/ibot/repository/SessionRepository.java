package com.example.ibot.repository;

import com.example.ibot.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, String> {
    List<Session> findByUserId(String userId);
}
