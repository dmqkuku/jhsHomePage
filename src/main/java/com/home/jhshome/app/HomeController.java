package com.home.jhshome.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @RequestMapping("/home")
    public List<WelcomeResponse> welcome(){

        List<WelcomeResponse> responseList = new ArrayList<>();

        responseList.add(new WelcomeResponse(1, "Welcome~1"));
        responseList.add(new WelcomeResponse(2, "My name is jhs"));
        responseList.add(new WelcomeResponse(3, "again. welcome!"));

        return responseList;
    }


    class WelcomeResponse {
        int idx;
        String message;

        WelcomeResponse(){}
        WelcomeResponse(int idx, String message){
            this.idx = idx;
            this.message = message;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
