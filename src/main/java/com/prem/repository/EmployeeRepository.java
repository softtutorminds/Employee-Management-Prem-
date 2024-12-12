package com.prem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prem.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
