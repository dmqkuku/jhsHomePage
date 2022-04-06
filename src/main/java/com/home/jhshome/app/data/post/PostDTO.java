package com.home.jhshome.app.data.post;

import com.home.jhshome.app.data.user.UserDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PostDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "PID")
    private int pid;

    @Column(columnDefinition = "TEXT", name = "POST_CNT")
    private String postCnt;

    @ManyToOne
    private UserDTO userDTO;


    @Column(name = "REGISTER_DATE")
    private Date registerDate;

    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPostCnt() {
        return postCnt;
    }

    public void setPostCnt(String postCnt) {
        this.postCnt = postCnt;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
