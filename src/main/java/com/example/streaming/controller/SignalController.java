package com.example.streaming.controller;

import com.example.streaming.model.SignalMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class SignalController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/signal")
    public void handleSignal(SignalMessage signal, Principal principal) {
        signal.setFrom(principal.getName());

        if (signal.getTo() != null && !signal.getTo().isEmpty()) {
            // 1-to-1 fallback
            messagingTemplate.convertAndSendToUser(signal.getTo(), "/queue/signal", signal);
        } else {
            // Broadcast from admin
            messagingTemplate.convertAndSend("/topic/signal", signal);
        }
    }
}

