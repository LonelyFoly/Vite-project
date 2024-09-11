package ru.yppsi.quixor.dto.task;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateTaskDto {

    private Long id;

    private String status;

    private String title;

    private String description;

    private LocalDate dueDate;
}
