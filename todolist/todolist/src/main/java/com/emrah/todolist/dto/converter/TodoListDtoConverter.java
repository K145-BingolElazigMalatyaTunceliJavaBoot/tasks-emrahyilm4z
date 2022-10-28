package com.emrah.todolist.dto.converter;


import com.emrah.todolist.dto.todo.TodoAddRequestDto;
import com.emrah.todolist.dto.todo.TodoResponseDto;
import com.emrah.todolist.dto.todo.TodoUpdateResponseDto;
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
    public static TodoUpdateResponseDto convertTodoUpdateDto(TodoList from) {
        return new TodoUpdateResponseDto(
                from.getDescription(),
                from.getStartTime(),
                from.getEndTime(),
                from.isDone()
        );
    }
}
