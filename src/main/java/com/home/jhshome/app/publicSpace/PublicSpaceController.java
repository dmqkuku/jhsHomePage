package com.home.jhshome.app.publicSpace;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/publicSpace")
public class PublicSpaceController {

    @RequestMapping("/welcome")
    public String welcome(Model model){

        return "publicSpace/welcome";
    }
    @MessageMapping("/welcome/ws")
    @SendTo("publicSpace/welcome")
    public WsResponse welcomewe(){
        return new WsResponse(new Date(), "Welcome! to WS!");
    }
    private class WsResponse{
        private Date serverTime;
        private String msg;

        private WsResponse(Date serverTime, String msg){
            this.serverTime = serverTime;
            this.msg = msg;
        }
    }

}
