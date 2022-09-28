package com.example.demo.controller;

import com.example.demo.entities.Employee;
import com.example.demo.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/departments")
@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/min")
    public Employee min(@RequestParam Integer department) {
        return departmentService.minSalaryEmployee(department);
    }

    @GetMapping("max")
    public Employee max(@RequestParam Integer department) {
        return departmentService.maxSalaryEmployee(department);
    }

    @GetMapping(value = "all", params = "department")
    public List<Employee> byDepartment(@RequestParam Integer department) {
        return departmentService.employeesInDepartment(department);
    }

    @GetMapping("all")
    public Map<Integer, List<Employee>> all() {
        return departmentService.employeesByDepartments();
    }
}
