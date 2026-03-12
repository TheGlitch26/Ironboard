package com.ironhack.IronBoard.dto.mapper;

import com.ironhack.IronBoard.dto.request.CreateProjectRequest;
import com.ironhack.IronBoard.dto.request.UpdateProjectRequest;
import com.ironhack.IronBoard.dto.response.ProjectResponse;
import com.ironhack.IronBoard.dto.response.ProjectSummary;
import com.ironhack.IronBoard.model.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectMapper {

    private ProjectMapper(){

    }

    public static Project toModel(CreateProjectRequest request){
        Project project = new Project();
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        return project;
    }

    public static Project toModel(UpdateProjectRequest request){
        Project project = new Project();
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        return project;
    }

    public static ProjectResponse toResponse(Project project){
        return new ProjectResponse(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getCreatedAt()
        );
    }

    public static ProjectSummary toSummary(Project project){
        return new ProjectSummary(project.getId(), project.getName());
    }

    public static List<ProjectSummary> toSummaryList(List<Project> projects){
        List<ProjectSummary> result = new ArrayList<>();

        for(Project project : projects){
            result.add(toSummary(project));
        }
        return result;
    }
}
