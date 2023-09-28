package com.example.pma.services;

import com.example.pma.dao.ProjectRepository;
import com.example.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository proRepo;

    public List<Project> findAll(){
        return proRepo.findAll();
    }

    public void save(Project project){
        proRepo.save(project);
    }
}
