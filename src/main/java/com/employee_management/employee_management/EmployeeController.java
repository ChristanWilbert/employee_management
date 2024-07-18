package com.employee_management.employee_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeManager Manager;

    @GetMapping(produces = "application/json")
    public String getMethodName() {
        return Manager.getAllEmployees();
    }

    @GetMapping(path = "/id", produces = "application/json")
    public String getMethodName(@RequestParam(value = "id", defaultValue = "1") String id) throws Exception {
        try {
            return Manager.getEmployee(id).toString();
        } catch (Exception e) {
            return e.getMessage();
        }

    }

}
