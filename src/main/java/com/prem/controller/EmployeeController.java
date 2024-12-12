package com.prem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prem.employeeService.EmployeeService;
import com.prem.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


	    private final EmployeeService employeeService;

	    @Autowired
	    public EmployeeController(EmployeeService employeeService) {
	        this.employeeService = employeeService;
	    }

	    @GetMapping
	    public String listEmployees(Model model) {
	        model.addAttribute("employees", employeeService.findAll());
	        return "employees/list";
	    }

	    @GetMapping("/new")
	    public String showCreateForm(Model model) {
	        model.addAttribute("employee", new Employee());
	        return "employees/form";
	    }

	    @PostMapping
	    public String saveEmployee(@ModelAttribute Employee employee) {
	        employeeService.save(employee);
	        return "redirect:/employees";
	    }

	    @GetMapping("/edit/{id}")
	    public String showEditForm(@PathVariable Long id, Model model) {
	        Employee employee = employeeService.findById(id).orElseThrow();
	        model.addAttribute("employee", employee);
	        return "employees/form";
	    }

	    @GetMapping("/delete/{id}")
	    public String deleteEmployee(@PathVariable Long id) {
	        employeeService.delete(id);
	        return "redirect:/employees";
	    }
	}


