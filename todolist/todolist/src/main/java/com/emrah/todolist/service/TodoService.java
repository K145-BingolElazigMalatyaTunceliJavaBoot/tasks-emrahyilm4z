package com.emrah.todolist.service;

import com.emrah.todolist.dataAccess.TodoListDao;
import com.emrah.todolist.dto.todo.TodoAddRequestDto;
import com.emrah.todolist.dto.todo.TodoResponseDto;
import com.emrah.todolist.dto.converter.TodoListDtoConverter;
import com.emrah.todolist.dto.todo.TodoUpdateResponseDto;
import com.emrah.todolist.entity.TodoList;
import com.emrah.todolist.exceptions.UserNotFoundId;
import org.modelmapper.ModelMapper;
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
    private TodoListDao todoListDao;

    @Autowired
    private ModelMapper modelMapper;
    private final SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public TodoService(TodoListDao todoListDao, SequenceGeneratorService sequenceGeneratorService) {
        this.sequenceGeneratorService = sequenceGeneratorService;
        this.todoListDao = todoListDao;
    }

    public List<TodoResponseDto> getAll() {
        return todoListDao.findAll().stream().map(TodoListDtoConverter::convertTodoResponseDto).toList();
    }

    public TodoAddRequestDto add(TodoList todoList) {
        todoList.setId(sequenceGeneratorService.getSequenceNumber(TodoList.SEQUENCE_NAME));
        todoListDao.save(todoList);
        TodoAddRequestDto todoAddRequestDto = TodoListDtoConverter.convertTodoAddRequestDto(todoList);
        return todoAddRequestDto;
    }

    public List<TodoResponseDto> getWeek() {
        List<TodoResponseDto> todoLists = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        int weekOfYear = localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        getAll().forEach((item) -> {
            if (item.getStartTime().get(ChronoField.ALIGNED_WEEK_OF_YEAR) == weekOfYear) {
                todoLists.add(item);
            }
        });
        return todoLists;
    }

    public List<TodoResponseDto> getMonth() {
        List<TodoResponseDto> todoLists = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        int monthOfYear = localDate.get(ChronoField.MONTH_OF_YEAR);
        getAll().forEach((item) -> {
            if (item.getStartTime().get(ChronoField.MONTH_OF_YEAR) == monthOfYear) {
                todoLists.add(item);
            }
        });
        return todoLists;
    }

    public List<TodoResponseDto> getDay() {
        List<TodoResponseDto> todoLists = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        int dayOfYear = localDate.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR);
        getAll().forEach((item) -> {
            if (item.getStartTime().get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR) == dayOfYear) {
                todoLists.add(item);
            }
        });
        return todoLists;
    }

    public List<TodoResponseDto> getNotDone() {
        return todoListDao.findByDoneIsFalse().stream().map(TodoListDtoConverter::convertTodoResponseDto).toList();
    }

    public ResponseEntity<Boolean> deleteTodo(int id) {
        todoListDao.deleteById(id);
        return new ResponseEntity<>(!todoListDao.existsById(id), HttpStatus.OK);
    }

    public TodoResponseDto done(int id) {
        TodoList todoList = todoListDao.findById(id).orElseThrow(UserNotFoundId::new);
        todoList.setDone(!todoList.isDone());
        todoListDao.save(todoList);
        TodoResponseDto todoResponseDto = TodoListDtoConverter.convertTodoResponseDto(todoList);
        return todoResponseDto;
    }

    public TodoUpdateResponseDto update(TodoList todoList) {
        todoListDao.findById(todoList.getId()).orElseThrow(UserNotFoundId::new);
        TodoList todoList1 = modelMapper.map(todoList, TodoList.class);
        todoListDao.save(todoList1);
        TodoUpdateResponseDto todoUpdateResponseDto = TodoListDtoConverter.convertTodoUpdateDto(todoList1);
        return todoUpdateResponseDto;
    }
}


