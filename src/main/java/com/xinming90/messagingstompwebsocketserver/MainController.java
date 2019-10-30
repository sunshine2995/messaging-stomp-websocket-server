package com.xinming90.messagingstompwebsocketserver;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public MainController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @GetMapping("/")
    public void index(@RequestParam String name, @RequestParam Integer id) {
        Greeting greeting = new Greeting("id: " + id + " Hello, " + name + "!");
        String destination = "/topic/products/" + id;
        simpMessagingTemplate.convertAndSend(destination, greeting);
    }
}
