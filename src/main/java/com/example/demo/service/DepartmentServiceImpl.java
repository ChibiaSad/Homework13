package com.example.demo.service;

import com.example.demo.entities.Employee;
import com.example.demo.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee minSalaryEmployee(int department) {
        Optional<Employee> employee = employeeService.getEmployeeBook().values().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Employee::compareSalary);
        return employee.orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee maxSalaryEmployee(int department) {
        Optional<Employee> employee = employeeService.getEmployeeBook().values().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Employee::compareSalary);
        return employee.orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> employeesInDepartment(int department) {
        return employeeService.getEmployeeBook().values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> employeesByDepartments() {
        return employeeService.getEmployeeBook().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
