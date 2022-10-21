package com.emrah.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoAddRequestDto {
    private int author;
    private String description;
    private LocalDate startTime;
    private LocalDate endTime;
    private boolean done;
}
