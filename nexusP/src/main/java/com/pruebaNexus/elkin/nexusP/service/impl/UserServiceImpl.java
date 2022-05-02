package com.pruebaNexus.elkin.nexusP.service.impl;

import com.pruebaNexus.elkin.nexusP.commons.exceptions.GenericConflictException;
import com.pruebaNexus.elkin.nexusP.dto.UserCreateDTO;
import com.pruebaNexus.elkin.nexusP.dto.UserDTO;
import com.pruebaNexus.elkin.nexusP.mapper.UserMapper;
import com.pruebaNexus.elkin.nexusP.model.User;
import com.pruebaNexus.elkin.nexusP.repository.UserRepository;
import com.pruebaNexus.elkin.nexusP.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.pruebaNexus.elkin.nexusP.exceptions.UserError.USER_NOT_FOUNT;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public void save(UserCreateDTO UserDTO) {
        log.debug("Request to save User : {}", UserDTO);
        userRepository.save(mapper.toEntity(UserDTO));
    }

    @Override
    public Page<UserDTO> SearchUser(String query, Pageable pageable) {
        log.debug("Request to search User");
        return userRepository.search(query, pageable).map(mapper::toDto);
    }

    @Override
    public Optional<UserDTO> findOne(Long id) {
        log.debug("Request to get User : {}", id);
        return userRepository.findById(id)
                .map(mapper::toDto);
    }

    @Override
    public UserDTO update(UserCreateDTO userDTO, Long id) {
        if(!userRepository.findById(id).isPresent()){
            throw new GenericConflictException(USER_NOT_FOUNT);
        }
        log.debug("Request to Update User : {}",userDTO);
        User user = mapper.toEntity(userDTO);
        user.setId(id);
        return mapper.toDto(userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
