package com.demidevs.restapi.restapi.Controller;

import java.util.List;

import javax.websocket.server.PathParam;

import com.demidevs.restapi.restapi.Model.Employee;
import com.demidevs.restapi.restapi.Service.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // ?build create employee
    @PostMapping("/add")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    //?get all employees
    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }
    //?get employee
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable("id") Long id) {
        return new ResponseEntity<Employee>(employeeService.getEmployee(id), HttpStatus.OK);
    }
    //?update
    @PutMapping("/{id}")
    public ResponseEntity<Employee> UpdateEmployee(@RequestBody Employee employee,@PathVariable("id") Long id) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id), HttpStatus.OK);
    }
    //? delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
    }
}
