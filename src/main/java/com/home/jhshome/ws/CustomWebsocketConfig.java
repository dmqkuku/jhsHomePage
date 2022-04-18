package com.home.jhshome.ws;

import com.home.jhshome.ws.CustomWebsocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
//@EnableWebSocket
@EnableWebSocketMessageBroker
public class CustomWebsocketConfig implements WebSocketMessageBrokerConfigurer{

//    @Bean
//    public WebSocketHandler customWebSocketHandler(){
//        return new CustomWebsocketHandler();
//    }
//
//    @Bean
//    public ServletServerContainerFactoryBean createWebSocketContainer(){
//        ServletServerContainerFactoryBean containerBean = new ServletServerContainerFactoryBean();
//        containerBean.setMaxTextMessageBufferSize(8192);
//        containerBean.setMaxBinaryMessageBufferSize(8192);
//        return containerBean;
//    }
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry){
//        registry.addHandler(customWebSocketHandler(), "/publicSpace/welcome/ws")
//                .addInterceptors(new HttpSessionHandshakeInterceptor())
//                .withSockJS();
//    }
    //, WebSocketMessageBrokerConfigurer
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        config.enableSimpleBroker("/");
        config.setApplicationDestinationPrefixes("/ws");
    }
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/publicSpace/welcome").withSockJS();
    }
}
