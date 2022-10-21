package com.emrah.todolist.dto.converter;


import com.emrah.todolist.dto.TodoAddRequestDto;
import com.emrah.todolist.dto.TodoResponseDto;
import com.emrah.todolist.entity.TodoList;

public class TodoListDtoConverter {
    public static TodoAddRequestDto convertTodoAddRequestDto(TodoList from) {
        return new TodoAddRequestDto(
                from.getUserId(),
                from.getDescription(),
                from.getStartTime(),
                from.getEndTime(),
                from.isDone()
        );
    }
    public static TodoResponseDto convertTodoResponseDto(TodoList from) {
        return new TodoResponseDto(
                from.getUserId(),
                from.getDescription(),
                from.getStartTime(),
                from.getEndTime(),
                from.isDone()
        );
    }
}
