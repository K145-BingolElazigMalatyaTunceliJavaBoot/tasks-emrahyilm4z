package com.emrah.todolist.controller;

import com.emrah.todolist.entity.TodoList;
import com.emrah.todolist.entity.User;
import com.emrah.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/todo")
public class TodoController {
    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/add")
    public ResponseEntity<TodoList> add(@RequestBody TodoList todoList) {
        return new ResponseEntity<TodoList>(this.todoService.add(todoList).getBody(), HttpStatus.OK);
    }

    @GetMapping("/week")
    public ResponseEntity<List<TodoList>> getWeek() {
        return new ResponseEntity<>(this.todoService.getWeek().getBody(), HttpStatus.OK);
    }

    @GetMapping("/month")
    public ResponseEntity<List<TodoList>> getMonth() {
        return new ResponseEntity<>(this.todoService.getMonth().getBody(), HttpStatus.OK);
    }

    @GetMapping("/day")
    public ResponseEntity<List<TodoList>> getDay() {
        return new ResponseEntity<>(this.todoService.getDay().getBody(), HttpStatus.OK);
    }

    @GetMapping("/notDone")
    public ResponseEntity<List<TodoList>> getNotDone() {
        return new ResponseEntity<>(this.todoService.getNotDone().getBody(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteTodo")
    public ResponseEntity<TodoList> delete(@RequestParam(name = "id") int id) {
        return new ResponseEntity<>(this.todoService.deleteTodo(id).getStatusCode());
    }

}
