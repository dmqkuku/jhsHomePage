package com.home.jhshome.app.publicSpace;

import org.springframework.messaging.handler.annotation.MessageMapping;
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
}
