package com.employee_management.employee_management;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeManager employeeRepository;

    @InjectMocks
    private EmployeeManager employeeService;

    private Employee employee1;
    private Employee employee2;
    private Employee employee3;

    @BeforeEach
    void setUp() {
        employee1 = new Employee(
                "1",
                "Prem",
                "Tiwari",
                "chapradreams@gmail.com", "CEO");

        employee2 = new Employee(
                "2", "Vikash",
                "Kumar",
                "abc@gmail.com", "CFO");

        employee3 = new Employee(
                "4", "Babu",
                "Ojha",
                "asdjf@gmail.com", "TL");
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> result = employeeService.getAllEmployees().getEmployeeList();

        assertEquals(4, result.size(), ("Expected 4 but got " + result.size() + " employees"));
    }

    @Test
    void testGetEmployeeById() throws Exception {
        Employee result = employeeService.getEmployee("1");
        assertInstanceOf(Employee.class, result);
        assertEquals("Prem", result.first_name);
    }

    @Test
    void testSaveEmployee() throws Exception {
        employeeService.addEmployee(employee3);
        Employee result = employeeService.getEmployee(employee3.employee_id);
        assertInstanceOf(Employee.class, result);
        assertEquals("Babu", result.first_name);
    }

}
