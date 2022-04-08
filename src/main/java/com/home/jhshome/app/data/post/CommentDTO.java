package com.home.jhshome.app.data.post;

import com.home.jhshome.app.data.user.UserDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COMMENT_DTO")
public class CommentDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CID", nullable = false, unique = true)
    private Integer cid;

    @OneToOne
    private PostDTO postDTO;

    @ManyToOne
    private CommentDTO commentDTO;

    @ManyToOne
    private UserDTO userDTO;

    @Column(name="COMMENT_CNT")
    private String commentCnt;

    @Column(name = "REGISTER_DATE")
    private Date registerDate;
    @Column(name = "UPDATE_DATE")
    private Date updateDate;
}
