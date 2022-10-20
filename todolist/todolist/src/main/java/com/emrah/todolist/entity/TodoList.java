package com.emrah.todolist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "todolist")
public class TodoList {
    private int userId;
    @Id
    private int id;
    private String description;
    private LocalDate startTime;
    private LocalDate endTime;
    private boolean done;
}
