package com.ironhack.IronBoard.dto.response;

public class TaskResponse {
    private final Long id;
    private final String title;
    private final String description;
    private final String status;
    private final String type;
    private final Long projectId;

    public TaskResponse(Long id, String title, String description, String status, String type, Long projectId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.type = type;
        this.projectId = projectId;
    }

    public Long getId() {
        return id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}
