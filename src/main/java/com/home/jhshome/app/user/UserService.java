package com.home.jhshome.app.user;

import com.home.jhshome.app.data.user.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserService extends JpaRepository<UserDTO, Integer> {

}
