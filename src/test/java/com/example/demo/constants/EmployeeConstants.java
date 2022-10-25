package com.example.demo.constants;

import com.example.demo.entities.Employee;

import java.util.List;
import java.util.Map;

public class EmployeeConstants {
    public static Employee EMPLOYEE_1 = new Employee("First", "First", 300, 1);
    public static Employee EMPLOYEE_2 = new Employee("Second", "Second", 200, 2);
    public static Employee EMPLOYEE_3 = new Employee("Third", "Third", 100, 1);
    public static Map<String, Employee> MAP_OF_EMPLOYEE_1 = Map.of("First First", EMPLOYEE_1);
    public static Map<String, Employee> MAP_OF_EMPLOYEE_3 = Map.of(
            "First First", EMPLOYEE_1,
            "Second Second", EMPLOYEE_2,
            "Third Third", EMPLOYEE_3);
    public static List<Employee> LIST_OF_1_DEPARTMENT = List.of(EMPLOYEE_1, EMPLOYEE_3);
    public static List<Employee> LIST_OF_2_DEPARTMENT = List.of(EMPLOYEE_2);

    public static Map<Integer, List<Employee>> MAP_OF_GROUPED_EMPLOYEES = Map.of(
            1, LIST_OF_1_DEPARTMENT,
            2, LIST_OF_2_DEPARTMENT);
}
