package com.emrah.todolist.service;

import com.emrah.todolist.dataAccess.UserDao;
import com.emrah.todolist.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public ResponseEntity<User> add(User user) {
        this.userDao.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(this.userDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<User> deleteUser(int id) {
        this.userDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
