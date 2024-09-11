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
import ru.yppsi.quixor.dto.project.ProjectDto;
import ru.yppsi.quixor.service.ProjectService;

import java.security.Principal;

@RestController
@Validated
@RequestMapping("/api/project")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping()
    @Operation(description = "Создать проект")
    public ResponseEntity<?> createProject(@RequestBody ProjectDto dto, Principal principal) {
        return projectService.createProject(dto, principal.getName());
    }

    @PutMapping()
    @Operation(description = "Обновить проект")
    public ResponseEntity<?> updateProject(@RequestBody ProjectDto dto, Principal principal) {
        return projectService.updateProject(dto, principal.getName());
    }

    @GetMapping("/all")
    @Operation(description = "Получить все проекты")
    public ResponseEntity<?> getAllProjects(Principal principal) {
        return projectService.getAllProjects();
    }

    @GetMapping()
    @Operation(description = "Найти проект")
    public ResponseEntity<?> findTask(@RequestParam String projectShortName) {
        return projectService.findProject(projectShortName);
    }
}
