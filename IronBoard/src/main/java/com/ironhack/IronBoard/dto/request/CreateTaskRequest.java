package com.ironhack.IronBoard.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateTaskRequest {

    @NotBlank
    @Size(min = 2, max = 200, message = "Task title must be between 2 and 200 characters")
    private String title;

    @Size(min = 1000, message = "Description must be at most 1000 characters")
    private String description;

    @Size(min = 2, max = 100, message = "Type must be between 2 and 100")
    private String type;

    @NotNull(message = "Project ID is required")
    private Long projectId;

    public CreateTaskRequest(){

    }


    //getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public Long getProjectId() {
        return projectId;
    }


    //setters
    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
