package com.emrah.todolist.service;

import com.emrah.todolist.dataAccess.TodoListDao;
import com.emrah.todolist.entity.TodoList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private final TodoListDao todoListDao;


    public TodoService(TodoListDao todoListDao) {
        this.todoListDao = todoListDao;
    }

    public ResponseEntity<List<TodoList>> getAll() {
        return new ResponseEntity<>(this.todoListDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<TodoList> add(TodoList todoList) {
        this.todoListDao.save(todoList);
        return new ResponseEntity<TodoList>(todoList, HttpStatus.OK);
    }

    public ResponseEntity<List<TodoList>> getWeek() {
        List<TodoList> nowTodoList = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        int weekOfYear = localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        getAll().getBody().forEach((item) -> {
            if (item.getStartTime().get(ChronoField.ALIGNED_WEEK_OF_YEAR) == weekOfYear) {
                nowTodoList.add(item);
            }
        });
        return new ResponseEntity<>(nowTodoList, HttpStatus.OK);
    }

    public ResponseEntity<List<TodoList>> getMonth() {
        List<TodoList> todoLists = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        int monthOfYear = localDate.get(ChronoField.MONTH_OF_YEAR);
        getAll().getBody().forEach((item) -> {
            if (item.getStartTime().get(ChronoField.MONTH_OF_YEAR) == monthOfYear) {
                todoLists.add(item);
            }
        });
        return new ResponseEntity<>(todoLists, HttpStatus.OK);
    }

    public ResponseEntity<List<TodoList>> getDay() {
        List<TodoList> todoLists = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        int dayOfYear = localDate.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR);
        getAll().getBody().forEach((item) -> {
            if (item.getStartTime().get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR) == dayOfYear) {
                todoLists.add(item);
            }
        });
        return new ResponseEntity<>(todoLists, HttpStatus.OK);
    }

    public ResponseEntity<List<TodoList>> getNotDone() {
        List<TodoList> todoLists = new ArrayList<>();
        getAll().getBody().forEach((item) -> {
            if (!item.isDone()) {
                todoLists.add(item);
            }
        });
        return new ResponseEntity<>(todoLists, HttpStatus.OK);
    }

    public ResponseEntity<TodoList> deleteTodo(int id) {
        this.todoListDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
