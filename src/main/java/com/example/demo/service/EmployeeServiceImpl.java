package com.example.demo.service;

import com.example.demo.entities.Employee;
import com.example.demo.exceptions.EmployeeAlreadyAddedException;
import com.example.demo.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public List<Employee> employeeBook = new ArrayList<>();

    @Override
    public void addEmployee(String firstName, String lastName) {
        try{
            findEmployee(firstName, lastName);
            throw new EmployeeAlreadyAddedException();
        }catch (EmployeeNotFoundException e){
            employeeBook.add(new Employee(firstName, lastName));
        }
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        employeeBook.remove(employee);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee testEmployee = new Employee(firstName, lastName);
        for (Employee employee : employeeBook) {
            if (employee.equals(testEmployee)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }
}
