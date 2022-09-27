package com.example.demo.service;

import com.example.demo.entities.Employee;
import com.example.demo.exceptions.EmployeeAlreadyAddedException;
import com.example.demo.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public Map<String, Employee> employeeBook = new HashMap<>();

    public Map<String, Employee> getEmployeeBook() {
        return employeeBook;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee testEmployee = new Employee(firstName, lastName);
        if (employeeBook.containsKey(testEmployee.toString())) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeBook.put(testEmployee.toString(), testEmployee);
        return testEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        employeeBook.remove(employee.toString());
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee testEmployee = new Employee(firstName, lastName);
        if (employeeBook.containsKey(testEmployee.toString())) {
            return testEmployee;
        }
        throw new EmployeeNotFoundException();
    }
}
