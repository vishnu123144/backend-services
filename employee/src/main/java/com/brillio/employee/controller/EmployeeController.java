package com.brillio.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.brillio.employee.model.Employee;
import com.brillio.employee.service.EmployeeService;

public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		return service.saveEmployee(employee);
	}
	@GetMapping("/get")
	public List<Employee> getBook(Employee employee)
	{
		return service.getEmployee();
	}

}
