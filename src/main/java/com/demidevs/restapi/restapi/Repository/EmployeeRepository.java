package com.demidevs.restapi.restapi.Repository;

import com.demidevs.restapi.restapi.Model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    
}
