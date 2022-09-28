package com.example.demo.service;

import com.example.demo.entities.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee minSalaryEmployee(int department);

    Employee maxSalaryEmployee(int department);

    List<Employee> employeesInDepartment(int department);

    Map<Integer, List<Employee>> employeesByDepartments();
}
