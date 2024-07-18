package com.employee_management.employee_management;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeManager Manager;

    @GetMapping(produces = "application/json")
    public String getEmployeesDetails() {
        return Manager.getAllEmployees().toString();
    }

    @GetMapping(path = "/id", produces = "application/json")
    public String getMethodName(@RequestParam(value = "id", defaultValue = "1") String id) throws Exception {
        try {
            return Manager.getEmployee(id).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> postnewEmployee(@RequestBody Employee employee) {
        Integer id = Manager.getAllEmployees().getEmployeeList().size() + 1;

        employee.setId(id.toString());

        Manager.addEmployee(employee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(
                        employee.getEmployee_id())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
