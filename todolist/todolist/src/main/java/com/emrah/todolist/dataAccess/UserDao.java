package com.emrah.todolist.dataAccess;

import com.emrah.todolist.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User, Integer> {
}
