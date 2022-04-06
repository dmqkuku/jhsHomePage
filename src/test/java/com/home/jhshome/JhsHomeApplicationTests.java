package com.home.jhshome;

import org.aspectj.bridge.Message;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@SpringBootTest
class JhsHomeApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void genPwd(){
        String input = "pop!1234";
        int strength = 10;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        String encodedPwd = encoder.encode(input);
        System.out.println(encodedPwd);
    }

}
