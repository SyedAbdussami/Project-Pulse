package com.example.pma.dao;

import com.example.pma.dto.ChartData;
import com.example.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project,Long> {
    public List<Project> findAll();


    //Fetches the no of projects for every status.
    @Query(nativeQuery = true,value = "select stage as label,count(*) as value from project " +
            "group by stage")
    public List<ChartData> projectStatus();

}
