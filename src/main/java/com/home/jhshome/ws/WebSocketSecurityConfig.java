package com.home.jhshome.ws;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;


//https://docs.spring.io/spring-security/reference/servlet/integrations/websocket.html
@Configuration
public class WebSocketSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

    @Override
    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages){
        messages.nullDestMatcher().authenticated()
                .simpDestMatchers("/publicSpace/welcome/ws").permitAll()
                .anyMessage().denyAll();
    }
}
