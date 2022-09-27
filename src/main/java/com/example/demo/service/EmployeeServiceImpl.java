package com.example.demo.service;

import com.example.demo.entities.Employee;
import com.example.demo.exceptions.EmployeeAlreadyAddedException;
import com.example.demo.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public Map<String, Employee> employeeBook = new HashMap<>();
    private final List<Integer> departments = new ArrayList<>(List.of(1, 2, 3, 4, 5));

    public Map<String, Employee> getEmployeeBook() {
        return employeeBook;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer salary, Integer department) {
        Employee testEmployee = new Employee(firstName, lastName, salary, department);
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
        if (employeeBook.containsKey(firstName + " " + lastName)) {
            return employeeBook.get(firstName + " " + lastName);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee minSalaryEmployee(int department){
        Optional<Employee> employee = employeeBook.values().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Employee::compareSalary);
        return employee.orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee maxSalaryEmployee(int department){
        Optional<Employee> employee = employeeBook.values().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Employee::compareSalary);
        return employee.orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> EmployeesInDepartment(int department) {
        return employeeBook.values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> EmployeesByDepartments(){
        Map<Integer, List<Employee>> employeesByDepartment = new HashMap<>();
        departments.forEach(d -> employeesByDepartment.put(d, EmployeesInDepartment(d)));
        return employeesByDepartment;
    }
}
