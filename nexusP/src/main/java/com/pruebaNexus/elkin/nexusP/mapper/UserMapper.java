package com.pruebaNexus.elkin.nexusP.mapper;

import com.pruebaNexus.elkin.nexusP.commons.model.EntityMapper;
import com.pruebaNexus.elkin.nexusP.dto.UserCreateDTO;
import com.pruebaNexus.elkin.nexusP.dto.UserDTO;
import com.pruebaNexus.elkin.nexusP.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses ={PositionMapper.class})
public interface UserMapper extends EntityMapper<UserDTO, User> {

    User toEntity(UserCreateDTO request);

    UserDTO toDto(User user);
}
