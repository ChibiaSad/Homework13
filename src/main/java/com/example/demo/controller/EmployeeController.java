package com.example.demo.controller;

import com.example.demo.entities.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("name") String firstName,
                                @RequestParam("surname") String lastName) {
        employeeService.addEmployee(firstName, lastName);
        return new Employee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("name") String firstName,
                                   @RequestParam("surname") String lastName) {
        employeeService.removeEmployee(firstName, lastName);
        return new Employee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("name") String firstName,
                                 @RequestParam("surname") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }
}
