package com.home.jhshome.app.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/new")
    public void newUser(){

    }


    @RequestMapping("/grant")
    public void grantUserRole(){

    }
}
