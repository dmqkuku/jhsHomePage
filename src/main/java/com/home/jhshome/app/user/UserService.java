package com.home.jhshome.app.user;

import com.home.jhshome.app.data.user.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserService extends JpaRepository<UserDTO, Integer> {
    Optional<UserDTO> findUserDTOByNameEquals(@NonNull String name);

    Optional<UserDTO> findUserDTOByUidEquals(@NonNull Integer uid);

}
