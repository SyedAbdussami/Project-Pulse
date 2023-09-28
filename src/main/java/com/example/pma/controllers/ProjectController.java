package com.example.pma.controllers;

import com.example.pma.dao.EmployeeRepository;
import com.example.pma.dao.ProjectRepository;
import com.example.pma.entities.Employee;
import com.example.pma.entities.Project;
import com.example.pma.services.EmployeeService;
import com.example.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectService proService;
//    @Autowired
//    EmployeeRepository employRep;
    @Autowired
    EmployeeService empService;

    @GetMapping
    public String displayProjects(Model model){
        List<Project> projects=proService.findAll();
        model.addAttribute("projectList",projects);
        return "projects/list-projects";
    }

    @RequestMapping("/new")
    public String displayProjectForm(Model model){
        model.addAttribute("project",new Project());
        List<Employee> employees=empService.findAll();
        model.addAttribute("allEmployees",employees);
        return "projects/new-project";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String createProject(Project project){
        //this route handles saving to the data base..
        proService.save(project);

        //This is used for ManyToOne Relation;
//       Iterable<Employee> chosenEmployees=employRep.findAllById(employees);
//       for (Employee emp:chosenEmployees){
//           emp.setProject(project);
//           //updating the tuple in the employee table
//           employRep.save(emp);
//       }

        return "redirect:/projects";
    }
}
