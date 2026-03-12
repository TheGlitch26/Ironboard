package com.ironhack.IronBoard.dto.response;

import java.io.FileReader;
import java.time.LocalDateTime;

public class ProjectResponse {

    private final Long id;
    private final String name;
    private final String description;
    private final LocalDateTime createdAt;

    public ProjectResponse(Long id, String name, String description, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }
}
