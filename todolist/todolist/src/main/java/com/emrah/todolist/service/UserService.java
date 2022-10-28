package com.emrah.todolist.service;

import com.emrah.todolist.dataAccess.UserDao;
import com.emrah.todolist.dto.UserResponseDto;
import com.emrah.todolist.dto.converter.UserDtoConverter;
import com.emrah.todolist.entity.User;
import com.emrah.todolist.exceptions.UserNotFoundId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public UserService(UserDao userDao, SequenceGeneratorService sequenceGeneratorService) {
        this.sequenceGeneratorService = sequenceGeneratorService;
        this.userDao = userDao;
    }

    public UserResponseDto add(User user) {
        user.setId(sequenceGeneratorService.getSequenceNumber(user.SEQUENCE_NAME));
        this.userDao.save(user);
        UserResponseDto userResponseDto = UserDtoConverter.convertUserResponseDto(user);
        return userResponseDto;
    }

    public List<UserResponseDto> getAll() {
        return userDao.findAll().stream().map(UserDtoConverter::convertUserResponseDto).toList();
    }

    public Boolean deleteUser(int id) {
        userDao.deleteById(id);
        return !userDao.existsById(id);
    }

    public UserResponseDto update(int id, String name) {
        User user = userDao.findById(id).orElseThrow(UserNotFoundId::new);
        user.setName(name);
        userDao.save(user);
        UserResponseDto userResponseDto = UserDtoConverter.convertUserResponseDto(user);
        return userResponseDto;
    }
}