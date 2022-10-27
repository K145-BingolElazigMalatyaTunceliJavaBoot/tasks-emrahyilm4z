package com.emrah.todolist.dataAccess;

import com.emrah.todolist.entity.TodoList;
import com.emrah.todolist.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TodoListDao extends MongoRepository<TodoList, Integer> {
//    @Query(value = "SELECT * FROM todolist WHERE done=0", nativeQuery = true)
//    List<TodoList> findByIsDone();

    List<TodoList> findByDoneIsFalse();
}
