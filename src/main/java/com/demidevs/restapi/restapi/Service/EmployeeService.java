package com.demidevs.restapi.restapi.Service;

import java.util.List;

import com.demidevs.restapi.restapi.Model.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployee(Long id);
    Employee updateEmployee(Employee employee, Long id);
    void deleteEmployee(Long id);
}
