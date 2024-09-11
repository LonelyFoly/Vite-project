package ru.yppsi.quixor.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.yppsi.quixor.dto.task.CreateTaskDto;
import ru.yppsi.quixor.dto.task.UpdateTaskDto;
import ru.yppsi.quixor.service.TaskService;

import java.security.Principal;

@RestController
@Validated
@RequestMapping("/api/task")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class TaskController {

    private final TaskService taskService;

    @PostMapping()
    @Operation(description = "Создать задачу")
    public ResponseEntity<?> createTask(@RequestBody CreateTaskDto dto, Principal principal) {
        return taskService.createTask(dto, principal.getName());
    }

    @PutMapping()
    @Operation(description = "Обновить задачу")
    public ResponseEntity<?> updateTask(@RequestBody UpdateTaskDto dto, Principal principal) {
        return taskService.updateTask(dto, principal.getName());
    }

    @GetMapping("/all")
    @Operation(description = "Получить все задачи")
    public ResponseEntity<?> getAllTasks(Principal principal) {
        return taskService.getAllTasks();
    }

    @GetMapping()
    @Operation(description = "Найти задачу")
    public ResponseEntity<?> findTask(@RequestParam String projectShortName,
                                      @RequestParam Long number) {
        return taskService.findTask(projectShortName, number);
    }
}
