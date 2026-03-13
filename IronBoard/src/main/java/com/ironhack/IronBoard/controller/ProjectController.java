package com.ironhack.IronBoard.controller;

import com.ironhack.IronBoard.dto.mapper.ProjectMapper;
import com.ironhack.IronBoard.dto.request.CreateProjectRequest;
import com.ironhack.IronBoard.dto.request.UpdateProjectRequest;
import com.ironhack.IronBoard.dto.response.ProjectResponse;
import com.ironhack.IronBoard.dto.response.ProjectSummary;
import com.ironhack.IronBoard.model.Project;
import com.ironhack.IronBoard.model.Task;
import com.sun.management.GarbageCollectorMXBean;
import jakarta.validation.Valid;
import org.springframework.boot.info.ProcessInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ironhack.IronBoard.service.ProjectService;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/api/projects")
public class ProjectController {
    public final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectSummary> getProjects(@RequestParam (required = false) String name){
        List<Project> projects;

        if(name != null && !name.isBlank()) {
            projects = projectService.findByName(name);
        }
        else {
            projects = projectService.findAll();
        }

        return ProjectMapper.toSummaryList(projects);
    }

    @GetMapping("/{id}")
    public ProjectResponse getProjectById(@PathVariable Long id){
        Project project = projectService.findById(id);
        return ProjectMapper.toResponse(project);
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@Valid @RequestBody CreateProjectRequest request){
        Project project = ProjectMapper.toModel(request);
        Project created = projectService.create(project);
        ProjectResponse response = ProjectMapper.toResponse(created);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ProjectResponse updateProject(@PathVariable Long id, @Valid @RequestBody UpdateProjectRequest request){
        Project updates = ProjectMapper.toModel(request);
        Project project = projectService.fullUpdate(id, updates);
        return ProjectMapper.toResponse(project);
    }

    @PatchMapping("/{id}")
    public ProjectResponse patchProject(@PathVariable Long id, @RequestBody UpdateProjectRequest request){
        Project updates = ProjectMapper.toModel(request);
        Project project = projectService.partialUpdate(id, updates);
        return ProjectMapper.toResponse(project);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }
}