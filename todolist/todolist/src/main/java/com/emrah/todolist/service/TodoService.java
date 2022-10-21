package com.emrah.todolist.service;

import com.emrah.todolist.dataAccess.TodoListDao;
import com.emrah.todolist.dto.TodoListDto;
import com.emrah.todolist.dto.UserDto;
import com.emrah.todolist.dto.converter.TodoListDtoConverter;
import com.emrah.todolist.entity.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
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

    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public TodoService(TodoListDao todoListDao, SequenceGeneratorService sequenceGeneratorService) {
        this.sequenceGeneratorService = sequenceGeneratorService;
        this.todoListDao = todoListDao;
    }

    public ResponseEntity<List<TodoListDto>> getAll() {
        List<TodoList> todoLists = this.todoListDao.findAll();
        List<TodoListDto> todoListDtos = new ArrayList<>();
        for (TodoList item : todoLists) {
            TodoListDto todoListDto = TodoListDtoConverter.convert(item);
            todoListDtos.add(todoListDto);
        }
        return new ResponseEntity<>(todoListDtos, HttpStatus.OK);
    }

    public ResponseEntity<TodoListDto> add(TodoList todoList) {
        todoList.setId(sequenceGeneratorService.getSequenceNumber(todoList.SEQUENCE_NAME));
        this.todoListDao.save(todoList);
        TodoListDto todoListDto = TodoListDtoConverter.convert(todoList);
        return new ResponseEntity<TodoListDto>(todoListDto, HttpStatus.OK);
    }

    public ResponseEntity<List<TodoListDto>> getWeek() {
        List<TodoListDto> todoLists = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        int weekOfYear = localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        getAll().getBody().forEach((item) -> {
            if (item.getStartTime().get(ChronoField.ALIGNED_WEEK_OF_YEAR) == weekOfYear) {
                todoLists.add(item);
            }
        });
        return new ResponseEntity<>(todoLists, HttpStatus.OK);
    }

    public ResponseEntity<List<TodoListDto>> getMonth() {
        List<TodoListDto> todoLists = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        int monthOfYear = localDate.get(ChronoField.MONTH_OF_YEAR);
        getAll().getBody().forEach((item) -> {
            if (item.getStartTime().get(ChronoField.MONTH_OF_YEAR) == monthOfYear) {
                todoLists.add(item);
            }
        });
        return new ResponseEntity<>(todoLists, HttpStatus.OK);
    }

    public ResponseEntity<List<TodoListDto>> getDay() {
        List<TodoListDto> todoLists = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        int dayOfYear = localDate.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR);
        getAll().getBody().forEach((item) -> {
            if (item.getStartTime().get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR) == dayOfYear) {
                todoLists.add(item);
            }
        });
        return new ResponseEntity<>(todoLists, HttpStatus.OK);
    }

    public ResponseEntity<List<TodoListDto>> getNotDone() {
        List<TodoListDto> todoLists = new ArrayList<>();
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

    public ResponseEntity<TodoListDto> done(int id) {
        List<TodoList> todoLists = this.todoListDao.findAll();
        TodoListDto todoListDto = null;
        for (TodoList item : todoLists) {
            if (item.getId() == id) {
                item.setDone(!item.isDone());
                todoListDto = TodoListDtoConverter.convert(item);
                this.todoListDao.save(item);
            }
        }
        return new ResponseEntity<>(todoListDto, HttpStatus.OK);
    }
}
