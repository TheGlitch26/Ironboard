package com.ironhack.IronBoard.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Task {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status = TaskStatus.TODO;
    private String type;
    private Long projectId;

    public Task(){

    }


    //getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Long getProjectId() {
        return projectId;
    }



    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
