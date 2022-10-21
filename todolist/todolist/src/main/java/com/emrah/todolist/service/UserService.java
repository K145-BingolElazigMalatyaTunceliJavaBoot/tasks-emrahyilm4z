package com.emrah.todolist.service;

import com.emrah.todolist.dataAccess.UserDao;
import com.emrah.todolist.dto.UserRequestDto;
import com.emrah.todolist.dto.UserResponseDto;
import com.emrah.todolist.dto.converter.UserDtoConverter;
import com.emrah.todolist.entity.User;
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

    public ResponseEntity<UserRequestDto> add(User user) {
        user.setId(sequenceGeneratorService.getSequenceNumber(user.SEQUENCE_NAME));
        this.userDao.save(user);
        UserRequestDto userResponseDto = UserDtoConverter.convertUserRequestDto(user);
        return new ResponseEntity<UserRequestDto>(userResponseDto, HttpStatus.OK);
    }

    public ResponseEntity<List<UserResponseDto>> getAll() {
        List<User> users = userDao.findAll();
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for (User user : users) {
            userResponseDtos.add(UserDtoConverter.convertUserResponseDto(user));
        }

        return new ResponseEntity<>(userResponseDtos, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> deleteUser(int id) {
        userDao.deleteById(id);
        return new ResponseEntity<>(!userDao.existsById(id),HttpStatus.OK);
    }
}