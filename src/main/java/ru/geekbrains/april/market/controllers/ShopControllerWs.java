package ru.geekbrains.april.market.controllers;


import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopControllerWs {
    @GetMapping("/hello")
    @SendTo("/api/v1/cart")
    public void greeting () {
        return ;
    }
}
