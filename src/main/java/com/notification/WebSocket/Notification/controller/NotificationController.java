package com.notification.WebSocket.Notification.controller;

import com.notification.WebSocket.Notification.ChatMessage.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

    @MessageMapping("/sendMessage") // Intercepting messages from the client -> /app/sendMessage
    @SendTo("/topic/notifications") // Broadcast the processed message to all subscribers
    public String sendMessage(Message content){
        System.out.println("Message: "+content.message());
        return content.user()+": "+content.message();
    }
}
