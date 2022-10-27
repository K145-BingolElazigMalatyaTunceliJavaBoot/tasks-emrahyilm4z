package com.emrah.todolist.dto.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoUpdateResponseDto {
    private String description;
    private LocalDate startTime;
    private LocalDate endTime;
    private boolean done;
}
