package com.example.demo.service;

import com.example.demo.entities.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> getEmployeeBook();
}
