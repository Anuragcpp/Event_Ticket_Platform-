package com.event.platform.ticktes.user.mapper;

import com.event.platform.ticktes.auth.model.dto.CreateNewUserRequestDto;
import com.event.platform.ticktes.user.model.User;
import com.event.platform.ticktes.user.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    public UserDto toDto(User user);

    @Mapping(target = "id" ,ignore = true)
    @Mapping(target = "name" ,ignore = true)
    User createUserDtoToUserEntity(CreateNewUserRequestDto createNewUserRequestDto);

}
