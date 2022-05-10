package com.senla.scooterrentalapp.mapper;

import com.senla.scooterrentalapp.dto.user.RegistrationUserDto;
import com.senla.scooterrentalapp.dto.user.UserDto;
import com.senla.scooterrentalapp.entity.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    RegistrationUserDto RegistrationUserDtoFromUser(User user);

    UserDto UserDtoFromUser(User user);

    User toUser(RegistrationUserDto registrationUserDto);

    User toUser(UserDto userDto);
}
