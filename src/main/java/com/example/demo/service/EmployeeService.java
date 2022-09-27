package com.example.demo.service;

import com.example.demo.entities.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, Integer salary, Integer department);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Map<String, Employee> getEmployeeBook();

    Map<Integer, List<Employee>> EmployeesByDepartments();

    List<Employee> EmployeesInDepartment(int department);

    Employee minSalaryEmployee(int department);

    Employee maxSalaryEmployee(int department);
}
