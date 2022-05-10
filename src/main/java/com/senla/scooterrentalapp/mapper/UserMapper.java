package com.senla.scooterrentalapp.mapper;

import com.senla.scooterrentalapp.dto.user.RegistrationUserDto;
import com.senla.scooterrentalapp.dto.user.UserDto;
import com.senla.scooterrentalapp.entity.user.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    RegistrationUserDto RegistrationUserDtoFromUser(User user);

    UserDto UserDtoFromUser(User user);

    User toUser(RegistrationUserDto registrationUserDto);

    User toUser(UserDto userDto);
}
