package com.ironhack.IronBoard.dto.response;

public class ProjectSummary {
    private final Long id;
    private final String name;

    public ProjectSummary(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
