package com.example.demo.service;

import com.example.demo.entities.Employee;
import com.example.demo.exceptions.BadEmployeeNameExeption;
import com.example.demo.exceptions.EmployeeAlreadyAddedException;
import com.example.demo.exceptions.EmployeeNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public Map<String, Employee> employeeBook = new HashMap<>();

    @Override
    public Map<String, Employee> getEmployeeBook() {
        return employeeBook;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer salary, Integer department) {
        if (!StringUtils.isAlphaSpace(firstName) || !StringUtils.isAlphaSpace(lastName)) {
            throw new BadEmployeeNameExeption();
        }

        Employee testEmployee = new Employee(StringUtils.capitalize(firstName),
                StringUtils.capitalize(lastName), salary, department);

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
        String key = firstName + " " + lastName;
        if (employeeBook.containsKey(key)) {
            return employeeBook.get(key);
        }
        throw new EmployeeNotFoundException();
    }
}
