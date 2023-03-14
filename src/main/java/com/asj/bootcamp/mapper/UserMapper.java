package com.asj.bootcamp.mapper;

import com.asj.bootcamp.dto.UserCompletoDTO;
import com.asj.bootcamp.dto.UserDTO;
import com.asj.bootcamp.dto.UserLoginDTO;
import com.asj.bootcamp.dto.UserToRegisterDTO;
import com.asj.bootcamp.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userEntityToUserDTO(User user);

    UserCompletoDTO userEntityToUserCompletoDTO(User user);

    User userToRegisterDTOToUserCompletoDTO(UserToRegisterDTO userToRegisterDTO);

    User userDTOToUserEntity(UserDTO userDTO);

    User userLoginDTOToUserEntity(UserLoginDTO userLoginDTO);

}