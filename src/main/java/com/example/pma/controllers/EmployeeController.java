package com.example.pma.controllers;

import com.example.pma.dao.EmployeeRepository;
import com.example.pma.entities.Employee;
import com.example.pma.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

//    @Autowired
//    EmployeeRepository employRep;
    @Autowired
    EmployeeService empService;


    @GetMapping
    public String displayEmployees(Model model){
        List<Employee> employees= empService.findAll();
        model.addAttribute("employeeList",employees);
        return "employees/list-employees";
    }

    @RequestMapping("/new")
    public String displayNewEmployeeForm(Model model){
        model.addAttribute("employee",new Employee());
        return "employees/new-Employee";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String createNewEmployee(Employee employee){
        empService.save(employee);
        return "redirect:/employees";
    }
}
