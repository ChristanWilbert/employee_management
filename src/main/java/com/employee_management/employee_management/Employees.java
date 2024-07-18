package com.employee_management.employee_management;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    private List<Employee> Emplist;

    public Employees(List<Employee> Emplist) {
        this.Emplist = Emplist;
    }

    public Employees() {
        this.Emplist = new ArrayList<>();
    }

    public List<Employee> getEmployeeList() {
        return Emplist;
    }

    public void setEmployees(List<Employee> Emplist) {
        this.Emplist = Emplist;
    }

    @Override
    public String toString() {
        return Emplist.toString();
    }

}
