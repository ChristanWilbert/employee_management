package com.employee_management.employee_management;

public class Employee {

    String employee_id, first_name, last_name, email, title;

    public Employee(String employee_id, String first_name, String last_name, String email, String title) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.title = title;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {

        return "Employee [id=" + employee_id + ", firstName=" + first_name + ", lastName=" + last_name + ", email="
                + email + ", title=" + title + "]";

    }

    public void setId(String id) {
        employee_id = id;
    }

}
