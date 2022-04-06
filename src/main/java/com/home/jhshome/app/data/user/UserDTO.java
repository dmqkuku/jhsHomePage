package com.home.jhshome.app.data.user;

import javax.persistence.*;

@Entity
public class UserDTO {

    //컬럼이 not null일때 int
    //물론 조인 걸다가 값이 null로 떨어질 수도 있다.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "UID", nullable = false, unique = true)
    private Integer uid;

    @Column(name = "NAME")
    private String name;
    @Column(name = "PWD")
    private String pwd;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
