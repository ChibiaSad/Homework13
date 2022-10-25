package com.example.demo.service;

import com.example.demo.exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.demo.constants.EmployeeConstants.*;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    void shouldReturnMinSalaryEmployee() {
        when(employeeServiceMock.getEmployeeBook()).thenReturn(MAP_OF_EMPLOYEE_3);
        assertEquals(EMPLOYEE_3, out.minSalaryEmployee(1));
    }

    @Test
    void shouldReturnMaxSalaryEmployee() {
        when(employeeServiceMock.getEmployeeBook()).thenReturn(MAP_OF_EMPLOYEE_3);
        assertEquals(EMPLOYEE_1, out.maxSalaryEmployee(1));
    }

    @Test
    void shouldReturnListOfEmployeesInDepartment() {
        when(employeeServiceMock.getEmployeeBook()).thenReturn(MAP_OF_EMPLOYEE_3);

        assertEquals(LIST_OF_1_DEPARTMENT.size(), out.employeesInDepartment(1).size());
        assertTrue(LIST_OF_1_DEPARTMENT.containsAll(out.employeesInDepartment(1)));
    }

    @Test
    void shouldReturnMapOfEmployeesByDepartments() {
        when(employeeServiceMock.getEmployeeBook()).thenReturn(MAP_OF_EMPLOYEE_3);

        assertEquals(MAP_OF_GROUPED_EMPLOYEES.size(), out.employeesByDepartments().size());
        MAP_OF_GROUPED_EMPLOYEES.forEach((key, value) ->
                assertTrue(out.employeesByDepartments().get(key).containsAll(value)));
    }

    @Test
    public void shouldThrowNotFoundExceptionMin(){
        when(employeeServiceMock.getEmployeeBook()).thenReturn(MAP_OF_EMPLOYEE_3);
        assertThrows(EmployeeNotFoundException.class, () -> out.minSalaryEmployee(3));
    }

    @Test
    public void shouldThrowNotFoundExceptionMax(){
        when(employeeServiceMock.getEmployeeBook()).thenReturn(MAP_OF_EMPLOYEE_3);
        assertThrows(EmployeeNotFoundException.class, () -> out.maxSalaryEmployee(3));
    }

    @Test
    void shouldReturnEmptyListOfEmployeesInDepartment() {
        when(employeeServiceMock.getEmployeeBook()).thenReturn(MAP_OF_EMPLOYEE_3);
        assertEquals(emptyList(), out.employeesInDepartment(3));
    }

}