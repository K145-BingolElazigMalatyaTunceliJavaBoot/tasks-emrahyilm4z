package com.emrah.todolist.dto.converter;

import com.emrah.todolist.dto.UserRequestDto;
import com.emrah.todolist.dto.UserResponseDto;
import com.emrah.todolist.entity.User;

public class UserDtoConverter {
    public static UserResponseDto convertUserResponseDto(User user) {
        return new UserResponseDto(
                user.getName()
        );
    }
    public static UserRequestDto convertUserRequestDto(User user) {
        return new UserRequestDto(
                user.getName()
        );
    }
}
