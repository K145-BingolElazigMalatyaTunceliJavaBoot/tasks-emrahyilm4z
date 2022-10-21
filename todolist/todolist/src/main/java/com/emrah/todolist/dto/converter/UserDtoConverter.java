package com.emrah.todolist.dto.converter;

import com.emrah.todolist.dto.UserDto;
import com.emrah.todolist.entity.User;

public class UserDtoConverter {
    public static UserDto convert(User user) {
        return new UserDto(
                user.getName()
        );
    }
}
