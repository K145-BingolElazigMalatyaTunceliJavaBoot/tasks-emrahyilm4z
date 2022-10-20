package com.emrah.todolist.dataAccess;

import com.emrah.todolist.entity.TodoList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoListDao extends MongoRepository<TodoList, Integer> {
}
