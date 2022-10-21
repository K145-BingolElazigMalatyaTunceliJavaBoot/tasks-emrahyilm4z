package com.emrah.todolist.controller;

import com.emrah.todolist.dto.UserDto;
import com.emrah.todolist.entity.User;
import com.emrah.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<List<User>>(this.userService.getAll().getBody(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserDto> add(@RequestBody User user) {
        return new ResponseEntity<UserDto>(this.userService.add(user).getBody(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<UserDto> delete(@RequestParam(name = "id") int id) {
        return new ResponseEntity<>(this.userService.deleteUser(id).getStatusCode());
    }
}
