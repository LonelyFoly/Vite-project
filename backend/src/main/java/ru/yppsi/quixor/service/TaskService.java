package ru.yppsi.quixor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.yppsi.quixor.dto.error.AppError;
import ru.yppsi.quixor.dto.task.CreateTaskDto;
import ru.yppsi.quixor.dto.task.UpdateTaskDto;
import ru.yppsi.quixor.entity.Project;
import ru.yppsi.quixor.entity.Task;
import ru.yppsi.quixor.entity.User;
import ru.yppsi.quixor.repository.ProjectRepository;
import ru.yppsi.quixor.repository.TaskRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final UserService userService;

    private final ProjectRepository projectRepository;

    private final TaskRepository taskRepository;

    public ResponseEntity<?> createTask(@RequestBody CreateTaskDto dto, String username) {
        Optional<User> user = userService.findByUsername(username);
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().body(new AppError(404, "Пользователь не найден"));
        }
        Optional<Project> project = projectRepository.findById(dto.getProjectShortName());
        if (project.isEmpty()) {
            return ResponseEntity.badRequest().body(new AppError(404, "Проект не найден"));
        }
        Task newTask = Task.builder()
                .project(project.get())
                .number(taskRepository.countByProject(project.get()) + 1)
                .creator(user.get())
                .status(dto.getStatus())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .dueDate(dto.getDueDate())
                .build();

        try {
            newTask = taskRepository.save(newTask);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AppError(500, e.getMessage()));
        }
        return ResponseEntity.ok(newTask);
    }

    public ResponseEntity<?> updateTask(@RequestBody UpdateTaskDto dto, String username) {
        Optional<User> user = userService.findByUsername(username);
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().body(new AppError(404, "Пользователь не найден"));
        }
        Optional<Task> optionalTask = taskRepository.findById(dto.getId());
        if (optionalTask.isEmpty()) {
            return ResponseEntity.badRequest().body(new AppError(404, "Задача не найдена"));
        }
        Task task = optionalTask.get();
        task.setStatus(dto.getStatus());
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDueDate(dto.getDueDate());

        try {
            task = taskRepository.save(task);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AppError(500, e.getMessage()));
        }
        return ResponseEntity.ok(task);
    }

    public ResponseEntity<?> getAllTasks() {
        return ResponseEntity.ok(taskRepository.findAll());
    }

    public ResponseEntity<?> findTask(String projectShortName, Long number) {
        Optional<Project> project = projectRepository.findById(projectShortName);
        if (project.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Optional<Task> optionalTask = taskRepository.findByProjectAndNumber(project.get(), number);
        if (optionalTask.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalTask.get());
    }
}
