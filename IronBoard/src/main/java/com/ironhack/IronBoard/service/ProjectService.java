package com.ironhack.IronBoard.service;


import com.ironhack.IronBoard.exception.ResourceNotFoundException;
import com.ironhack.IronBoard.model.Project;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectService {
    private final Map<Long, Project> projects = new HashMap<>();

    private Long nextId = 1L;

    public ProjectService() {

        //seed project 1
        Project p1 = new Project();
        p1.setId(nextId++);
        p1.setName("Ironboard");
        p1.setDescription("A platform for students to share their projects");
        p1.setCreatedAt(LocalDateTime.now());
        projects.put(p1.getId(), p1);

        //seed project 2
        Project p2 = new Project();
        p2.setId(nextId++);
        p2.setName("IronLibrary");
        p2.setDescription("A library management project");
        p2.setCreatedAt(LocalDateTime.now());
        projects.put(p2.getId(), p2);
    }

    public List<Project> findAll(){
        return new ArrayList<>(projects.values());
    }

    public Project findById(Long id){
        Project project = projects.get(id);
        if(project == null){
            throw new ResourceNotFoundException("Project", id);
        }
        return project;
    }

    public List<Project> findByName(String name){
        List<Project> result = new ArrayList<>();
        String lowerName = name.toLowerCase();
        for(Project p : projects.values()){
            if(p.getName().toLowerCase().contains(lowerName)){
                result.add(p);
            }
        }
        return result;
    }

    public Project create(Project project){
        project.setId(nextId++);
        project.setCreatedAt(LocalDateTime.now());
        projects.put(project.getId(), project);
        return project;
    }

    public Project fullUpdate(Long id, Project updates){
        Project project = findById(id);
        project.setName(updates.getName());
        project.setDescription(updates.getDescription());
        return project;
    }

    public Project partialUpdate(Long id, Project updates){
        Project project = findById(id);

        if(updates.getName() != null){
            project.setName(updates.getName());
        }
        if(updates.getDescription() != null){
            project.setDescription(updates.getDescription());
        }

        return project;
    }

    public void delete(Long id){
        findById(id);
        projects.remove(id);
    }
}
