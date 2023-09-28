package com.example.pma.controllers;

import com.example.pma.dao.EmployeeRepository;
import com.example.pma.dao.ProjectRepository;
import com.example.pma.dto.ChartData;
import com.example.pma.dto.EmployeeProject;
import com.example.pma.entities.Employee;
import com.example.pma.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {
    @Value("${version}")
    private String version;

    @Autowired
    ProjectRepository proRep;
    @Autowired
    EmployeeRepository empRep;

    @RequestMapping("/")
    public String showDashboard(Model model) throws JsonProcessingException {
        model.addAttribute("versionNumber",version);
        List<Project> projectList = proRep.findAll();
        List<EmployeeProject> employeeProjectsCountList = empRep.employeeProjects();
        model.addAttribute("projectList", projectList);

        List<ChartData> projectChartData=proRep.projectStatus();
        // converting java object to json to use it in javascript.
        ObjectMapper objMap=new ObjectMapper();
        String jsonAsString = objMap.writeValueAsString(projectChartData);
        model.addAttribute("projectStatusCount",jsonAsString);
        model.addAttribute("employeeList", employeeProjectsCountList);
        return "main/home";
    }
}
