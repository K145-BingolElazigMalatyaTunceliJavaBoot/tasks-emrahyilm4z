package com.emrah.todolist.service;

import com.emrah.todolist.dataAccess.UserDao;
import com.emrah.todolist.dto.UserDto;
import com.emrah.todolist.dto.converter.UserDtoConverter;
import com.emrah.todolist.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    public ResponseEntity<UserDto> add(User user) {
        user.setId(sequenceGeneratorService.getSequenceNumber(user.SEQUENCE_NAME));
        this.userDao.save(user);
        UserDto userDto = UserDtoConverter.convert(user);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }

    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(this.userDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<UserDto> deleteUser(int id) {
        this.userDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
