package br.com.gilaguiar.devshowcase.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.gilaguiar.devshowcase.dto.ProjectRequestDTO;
import br.com.gilaguiar.devshowcase.dto.ProjectResponseDTO;
import br.com.gilaguiar.devshowcase.service.ProjectService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> create(
            @Valid @RequestBody ProjectRequestDTO dto) {

        ProjectResponseDTO project = projectService.create(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(project);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> findAll() {

        return ResponseEntity.ok(
                projectService.findAll()
        );
    }
}