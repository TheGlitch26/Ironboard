package com.ironhack.IronBoard.dto.mapper;

import com.ironhack.IronBoard.dto.request.CreateTaskRequest;
import com.ironhack.IronBoard.dto.request.UpdateTaskRequest;
import com.ironhack.IronBoard.dto.response.TaskResponse;
import com.ironhack.IronBoard.model.Task;
import com.ironhack.IronBoard.model.TaskStatus;

import java.util.ArrayList;
import java.util.List;

public class TaskMapper {

    public TaskMapper() {
    }

    public static Task toModel(CreateTaskRequest request){
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setType(request.getType());
        task.setProjectId(request.getProjectId());
        return task;
    }

    public static Task toModel(UpdateTaskRequest request){
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setType(request.getType());

        if(request.getStatus() != null){
            task.setStatus(TaskStatus.valueOf(request.getStatus()));
        }
        return task;
    }

    public static TaskResponse toResponse(Task task){
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus().name(),
                task.getType(),
                task.getProjectId()
        );
    }

    public static List<TaskResponse> toResponseList(List<Task> tasks){
        List<TaskResponse> result = new ArrayList<>();

        for (Task task : tasks){
            result.add(toResponse(task));
        }
        return result;
    }
}
