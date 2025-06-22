// SignalController.java
package com.example.streaming.controller;

import com.example.streaming.model.SignalMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class SignalController {

    @MessageMapping("/signal")
    @SendTo("/topic/signal")
    public SignalMessage forwardSignal(SignalMessage signal, Principal principal) {
        signal.setFrom(principal.getName());
        return signal;
    }
}
