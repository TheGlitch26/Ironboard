package com.ironhack.IronBoard.controller;


import com.ironhack.IronBoard.dto.mapper.TaskMapper;
import com.ironhack.IronBoard.dto.request.CreateTaskRequest;
import com.ironhack.IronBoard.dto.request.UpdateTaskRequest;
import com.ironhack.IronBoard.dto.response.TaskResponse;
import com.ironhack.IronBoard.model.Task;
import com.ironhack.IronBoard.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.TreeMap;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskResponse> getTasks(@RequestParam(required = false) Long projectId) {
        List<Task> tasks;
        if(projectId != null){
            tasks = taskService.findByProjectId(projectId);
        }
        else {
            tasks = taskService.findAll();
        }
        return TaskMapper.toResponseList(tasks);
    }

    @GetMapping("/{id}")
    public TaskResponse getTaskById(@PathVariable Long id){
        Task task = taskService.findById(id);
        return TaskMapper.toResponse(task);
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody CreateTaskRequest request){
        Task task = TaskMapper.toModel(request);
        Task created = taskService.create(task);
        TaskResponse response = TaskMapper.toResponse(created);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public TaskResponse replaceTask(@PathVariable Long id, @Valid @RequestBody UpdateTaskRequest request){
        Task updates = TaskMapper.toModel(request);
        Task task = taskService.fullUpdate(id, updates);
        return TaskMapper.toResponse(task);
    }

    @PatchMapping("/{id}")
    public TaskResponse updateTask(@PathVariable Long id, @RequestBody UpdateTaskRequest request){
        Task updates = TaskMapper.toModel(request);
        Task task = taskService.partialUpdate(id, updates);
        return TaskMapper.toResponse(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
