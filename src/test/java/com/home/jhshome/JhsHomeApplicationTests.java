package com.home.jhshome;

import com.home.jhshome.jwt.JwtTokenUtil;
import org.aspectj.bridge.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.awt.event.InputMethodListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SpringBootTest
class JhsHomeApplicationTests {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

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

    @Test
    void doJwtTokenTestForAuth0(){
        final String username = "sa";
        UserDetails userDetails = new User("sa", "1234", new ArrayList<>());
        String jwtToken = jwtTokenUtil.doGenerateToken(userDetails);
        System.out.println(jwtToken);
    }


 /*   @Test
    void doTest3(){
        List<Integer> intList1 = new ArrayList<>();
        List<Number> numList1 = new ArrayList<>();
        //intList1 = numList1;
        List<? extends Integer> intList2 = new ArrayList<>();
        List<? extends Number> numList2 = intList2;

    }

    public class WildCardError{
        void foo(List<?> i){
            System.out.println(i.get(0));
        }
    }


    public class MyCustormType {
        public void invokeMe(){

        }
    }
    public class Processor {
        public void processMe(List<?> list){
            for(var elem : list){
                elem.toString();
            }
        }
    }
    @Test
    void doTest2(){
        MyCustormType myType = new MyCustormType();
        Processor processor = new Processor();
        List<Object> list = new ArrayList<>();
        list.add(myType);
        processor.processMe(list);
        WildCardError wild = new WildCardError();
        wild.foo(list);
    }
*/
//    @Test
//    void genericTest(){
//        MyNode nm = new MyNode(5);
//        Node n = nm;
//        n.setData("Hello");
//        Integer x = nm.data;
//    }
//
//
//    public class Node<T>{
//        public T data;
//
//        public Node(T data) {this.data = data;}
//
//        public void setData(T data){
//            System.out.println("Node.setData");
//            this.data=data;
//        }
//    }
//    public class MyNode extends Node<Integer>{
//        public MyNode(Integer data) {super(data);}
//        public void setData(Integer data){
//            super.setData(data);
//        }
//    }
}
