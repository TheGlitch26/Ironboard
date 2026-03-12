package com.ironhack.IronBoard.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateProjectRequest {

    @Size(min = 2, max = 100, message = "Project name must be between 2 and 100 characters")
    private String name;

    @Size(max = 500, message = "Description must be at most 500 characters")
    private String description;

    public UpdateProjectRequest() {

    }


    //getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
