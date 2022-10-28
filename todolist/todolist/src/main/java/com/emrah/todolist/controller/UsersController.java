package com.emrah.todolist.controller;

import com.emrah.todolist.dto.UserResponseDto;
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
    public ResponseEntity<List<UserResponseDto>> getAll() {
        return new ResponseEntity<List<UserResponseDto>>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserResponseDto> add(@RequestBody User user) {
        return new ResponseEntity<UserResponseDto>(userService.add(user), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public Boolean delete(@RequestParam(name = "id") int id) {
        return userService.deleteUser(id);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<UserResponseDto> update(@RequestParam (name = "id") int id, @RequestParam (name = "name")String name){
        return new ResponseEntity<>(userService.update(id,name),HttpStatus.OK);
    }
}
