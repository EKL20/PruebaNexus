package com.pruebaNexus.elkin.nexusP.service;

import com.pruebaNexus.elkin.nexusP.dto.UserCreateDTO;
import com.pruebaNexus.elkin.nexusP.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    void save(UserCreateDTO UserDTO);

    Page<UserDTO> SearchUser(String query, Pageable pageable);

    Optional<UserDTO> findOne(Long id);

    UserDTO update(UserCreateDTO userDTO, Long id);

    void delete(Long id);
}
