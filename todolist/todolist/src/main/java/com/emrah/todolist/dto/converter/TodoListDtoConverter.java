package com.emrah.todolist.dto.converter;


import com.emrah.todolist.dto.TodoListDto;
import com.emrah.todolist.entity.TodoList;

public class TodoListDtoConverter {
    public static TodoListDto convert(TodoList from) {
        return new TodoListDto(
                from.getUserId(),
                from.getDescription(),
                from.getStartTime(),
                from.getEndTime(),
                from.isDone()
        );
    }
}
