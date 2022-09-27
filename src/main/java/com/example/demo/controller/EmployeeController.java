package com.example.demo.controller;

import com.example.demo.entities.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("name") String firstName,
                                @RequestParam("surname") String lastName,
                                @RequestParam Integer salary,
                                @RequestParam Integer department) {
        return employeeService.addEmployee(firstName, lastName, salary, department);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("name") String firstName,
                                   @RequestParam("surname") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("name") String firstName,
                                 @RequestParam("surname") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/list")
    public Map<String, Employee> getList(){
        return employeeService.getEmployeeBook();
    }

    @GetMapping("/departments/min")
    public Employee min(@RequestParam Integer department){
        return employeeService.minSalaryEmployee(department);
    }

    @GetMapping("/departments/max")
    public Employee max(@RequestParam Integer department){
        return employeeService.maxSalaryEmployee(department);
    }
    @GetMapping("/departments/all-by-department")
    public List<Employee> byDepartment(@RequestParam Integer department) {
        return employeeService.EmployeesInDepartment(department);
    }
    @GetMapping("/departments/all")
    public Map<Integer, List<Employee>> all(){
        return employeeService.EmployeesByDepartments();
    }
}
