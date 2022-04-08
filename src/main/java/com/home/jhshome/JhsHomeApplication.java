package com.home.jhshome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class JhsHomeApplication {



    public static void main(String[] args) {

        SpringApplication.run(JhsHomeApplication.class, args);
    }

}
