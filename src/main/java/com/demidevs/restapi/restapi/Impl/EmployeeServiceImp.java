package com.demidevs.restapi.restapi.Impl;

import java.util.List;
import java.util.Optional;

import com.demidevs.restapi.restapi.Expeption.ResourceNotFoundException;
import com.demidevs.restapi.restapi.Model.Employee;
import com.demidevs.restapi.restapi.Repository.EmployeeRepository;
import com.demidevs.restapi.restapi.Service.EmployeeService;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        // Optional<Employee> employee = employeeRepository.findById(id);
        // if (employee.isPresent()) {
        // return employee.get();
        // } else {
        // throw new ResourceNotFoundException("Employee", "Id", id);
        // }
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        // ? check if employee exists
        Employee searchResult = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        searchResult.setEmail(employee.getEmail());
        searchResult.setFirstName(employee.getFirstName());
        searchResult.setLastName(employee.getLastName());
        employeeRepository.save(searchResult);
        return searchResult;
    }

    @Override
    public void deleteEmployee(Long id) {
        // ? check if employee exists
        Employee searchResult = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        employeeRepository.deleteById(id);
    }

}
