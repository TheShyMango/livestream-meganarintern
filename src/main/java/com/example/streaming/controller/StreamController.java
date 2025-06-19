package com.example.streaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StreamController {

    @GetMapping("/stream")
    public String streamPage() {
        return "stream"; // maps to stream.html
    }
}
