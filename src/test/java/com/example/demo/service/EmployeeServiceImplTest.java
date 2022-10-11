package com.example.demo.service;

import com.example.demo.exceptions.BadEmployeeNameExeption;
import com.example.demo.exceptions.EmployeeAlreadyAddedException;
import com.example.demo.exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.demo.constants.EmployeeConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    private EmployeeServiceImpl out;

    @BeforeEach
    public void setUp(){
        out = new EmployeeServiceImpl();
    }

    @Test
    void shouldReturnMapEmployeeBook() {
        out.addEmployee("first", "first", 100, 1);
        assertEquals(MAP_OF_EMPLOYEE_1, out.getEmployeeBook());
    }

    @Test
    void shouldAddEmployee() {
        assertEquals(EMPLOYEE_1, out.addEmployee("first", "first", 100, 1));
    }

    @Test
    void shouldRemoveEmployee() {
        out.addEmployee("first", "first", 100, 1);
        assertEquals(EMPLOYEE_1, out.removeEmployee("first", "first"));
    }

    @Test
    void shouldFindEmployee() {
        out.addEmployee("first", "fIRST", 100, 1);
        assertEquals(EMPLOYEE_1, out.findEmployee("first", "first"));
    }

    @Test
    public void shouldThrowBadNameException(){
        assertThrows(BadEmployeeNameExeption.class,
                () -> out.addEmployee("first1", "last2", 100, 1));
    }

    @Test
    public void shouldThrowExistException(){
        out.addEmployee("first", "first", 100, 1);
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.addEmployee("first", "first", 100, 1));
    }

    @Test
    public void shouldThrowNotFoundException(){
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee("first", "first"));
    }
}