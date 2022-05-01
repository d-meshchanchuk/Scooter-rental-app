package com.senla.scooterrentalapp.mapper;

import com.senla.scooterrentalapp.dto.user.RegistrationUserDto;
import com.senla.scooterrentalapp.dto.user.UserDto;
import com.senla.scooterrentalapp.entity.user.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);
    RegistrationUserDto RegistrationUserDtoFromUser(User user);
    UserDto UserDtoFromUser(User user);
    @InheritInverseConfiguration
    User toUser(RegistrationUserDto registrationUserDto);
    @InheritInverseConfiguration
    User toUser(UserDto userDto);
}
