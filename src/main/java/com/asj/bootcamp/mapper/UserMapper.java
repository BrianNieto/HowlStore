package com.asj.bootcamp.mapper;

import com.asj.bootcamp.dto.UserDTO;
import com.asj.bootcamp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userEntityToUserDTO(User user);

    User userDTOToUserEntity(UserDTO userDTO);

}