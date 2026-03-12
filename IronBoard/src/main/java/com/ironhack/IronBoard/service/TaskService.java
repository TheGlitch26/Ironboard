package com.ironhack.IronBoard.service;

import com.ironhack.IronBoard.exception.ResourceNotFoundException;
import com.ironhack.IronBoard.model.Task;
import com.ironhack.IronBoard.model.TaskStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {
    private final Map<Long, Task> tasks = new HashMap<>();


    private Long nextId = 1L;

    private final ProjectService projectService;

    public TaskService(ProjectService projectService){
        this.projectService = projectService;

        Task t1 = new Task();
        t1.setId(nextId++);
        t1.setType("Feature");
        t1.setDescription("Description 1");
        t1.setStatus(TaskStatus.TODO);
        t1.setProjectId(1L);
        t1.setTitle("Features");
        tasks.put(t1.getId() ,t1);
    }

    public List<Task> findAll(){
        return new ArrayList<>(tasks.values());
    }

    public Task findById(Long id){
        Task task = tasks.get(id);
        if(task == null){
            throw new ResourceNotFoundException("Task", id);
        }
        return task;
    }

    public Task create(Task task){
        projectService.findById(task.getProjectId());
        task.setId(nextId++);
        task.setStatus(TaskStatus.TODO);
        tasks.put(task.getId(), task);
        return task;
    }


    public Task fullUpdate(Long id, Task updates){
        Task task = findById(id);
        task.setTitle(updates.getTitle());
        task.setDescription(updates.getDescription());
        task.setTitle(updates.getType());
        return task;
    }


    public List<Task> findByProjectId(Long projectId){
        List<Task> result = new ArrayList<>();

        for(Task task : tasks.values()){
            if(task.getProjectId().equals(projectId)){
                result.add(task);
            }
        }
        return result;
    }

    public Task partialUpdate(Long id, Task updates){
        Task task = findById(id);

        if(updates.getType() != null){
            task.setTitle(updates.getTitle());
        }
        if(updates.getDescription() != null){
            task.setDescription(updates.getDescription());
        }
        if(updates.getStatus() != null){
            task.setStatus(updates.getStatus());
        }
        if(updates.getType() != null){
            task.setType(updates.getType());
        }

        return task;
    }


    public void delete(Long id){
        findById(id);
        tasks.remove(id);
    }

}
