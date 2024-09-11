package ru.yppsi.quixor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.yppsi.quixor.dto.error.AppError;
import ru.yppsi.quixor.dto.project.ProjectDto;
import ru.yppsi.quixor.entity.Project;
import ru.yppsi.quixor.entity.User;
import ru.yppsi.quixor.repository.ProjectRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final UserService userService;

    private final ProjectRepository projectRepository;

    public ResponseEntity<?> createProject(@RequestBody ProjectDto dto, String username) {
        Optional<User> user = userService.findByUsername(username);
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().body(new AppError(404, "Пользователь не найден"));
        }
        Optional<Project> project = projectRepository.findById(dto.getShortName());
        if (project.isPresent()) {
            return ResponseEntity.badRequest().body(new AppError(404, "Проект найден"));
        }
        Project newProject = Project.builder()
                .shortName(dto.getShortName())
                .name(dto.getName())
                .creator(user.get())
                .build();

        try {
            newProject = projectRepository.save(newProject);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AppError(500, e.getMessage()));
        }
        return ResponseEntity.ok(newProject);
    }

    public ResponseEntity<?> updateProject(@RequestBody ProjectDto dto, String username) {
        Optional<User> user = userService.findByUsername(username);
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().body(new AppError(404, "Пользователь не найден"));
        }
        Optional<Project> optionalProject = projectRepository.findById(dto.getShortName());
        if (optionalProject.isEmpty()) {
            return ResponseEntity.badRequest().body(new AppError(404, "Проект не найдена"));
        }
        Project project = optionalProject.get();
        project.setName(dto.getName());

        try {
            project = projectRepository.save(project);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AppError(500, e.getMessage()));
        }
        return ResponseEntity.ok(project);
    }

    public ResponseEntity<?> getAllProjects() {
        return ResponseEntity.ok(projectRepository.findAll());
    }

    public ResponseEntity<?> findProject(String projectShortName) {
        Optional<Project> optionalProject = projectRepository.findById(projectShortName);
        if (optionalProject.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalProject.get());
    }
}
