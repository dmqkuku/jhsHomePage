package com.home.jhshome.ws;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Date;

public class CustomWebsocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message){

        try {
            final Date currDate = new Date();
            TextMessage newMsg = new TextMessage(currDate.toString());
            session.sendMessage(newMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
