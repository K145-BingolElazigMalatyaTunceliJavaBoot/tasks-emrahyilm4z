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
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

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
        LocalDate localDate = LocalDate.now();
        int weekOfYear = localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        return getAll().stream().filter((item) -> item.getStartTime().get(ChronoField.ALIGNED_WEEK_OF_YEAR) == weekOfYear).toList();
    }

    public List<TodoResponseDto> getMonth() {
        LocalDate localDate = LocalDate.now();
        int monthOfYear = localDate.get(ChronoField.MONTH_OF_YEAR);
        return  getAll().stream().filter((item)-> item.getStartTime().get(ChronoField.MONTH_OF_YEAR) == monthOfYear).toList();
    }

    public List<TodoResponseDto> getDay() {
        LocalDate localDate = LocalDate.now();
        int dayOfYear = localDate.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR);
        return getAll().stream().filter((item) -> item.getStartTime().get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR) == dayOfYear).toList();
    }

    public List<TodoResponseDto> getNotDone() {
        return todoListDao.findByDoneIsFalse().stream().map(TodoListDtoConverter::convertTodoResponseDto).toList();
    }

    public Boolean deleteTodo(int id) {
        todoListDao.deleteById(id);
        return !todoListDao.existsById(id);
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


