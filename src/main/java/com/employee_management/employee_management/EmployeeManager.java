package com.employee_management.employee_management;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeManager {

        private static final Employees list = new Employees();

        static {

                list.getEmployeeList().add(
                                new Employee(
                                                "1",
                                                "Prem",
                                                "Tiwari",
                                                "chapradreams@gmail.com", "CEO"));

                list.getEmployeeList().add(
                                new Employee(
                                                "2", "Vikash",
                                                "Kumar",
                                                "abc@gmail.com", "CFO"));

                list.getEmployeeList().add(
                                new Employee(
                                                "3", "Ritesh",
                                                "Ojha",
                                                "asdjf@gmail.com", "TL"));

        }

        public Employees getAllEmployees() {

                return list;
        }

        public void addEmployee(Employee employee) {
                list.getEmployeeList()
                                .add(employee);

        }

        public Employee getEmployee(String id) throws Exception {
                for (Employee e : list.getEmployeeList()) {
                        if (e.getEmployee_id() == null ? id == null : e.getEmployee_id().equals(id))
                                return e;
                }
                throw new NoSuchElementException("Employee with ID " + id + " not found.");
        }

}
