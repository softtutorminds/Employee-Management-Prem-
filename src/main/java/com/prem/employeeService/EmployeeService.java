package com.prem.employeeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prem.model.Employee;
import com.prem.repository.EmployeeRepository;

@Service
public class EmployeeService {



	    private final EmployeeRepository employeeRepository;

	    @Autowired
	    public EmployeeService(EmployeeRepository employeeRepository) {
	        this.employeeRepository = employeeRepository;
	    }

	    public List<Employee> findAll() {
	        return employeeRepository.findAll();
	    }

	    public Optional<Employee> findById(Long id) {
	        return employeeRepository.findById(id);
	    }

	    public Employee save(Employee employee) {
	        return employeeRepository.save(employee);
	    }

	    public void delete(Long id) {
	        employeeRepository.deleteById(id);
	    }
	}


