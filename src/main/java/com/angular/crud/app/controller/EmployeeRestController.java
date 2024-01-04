package com.angular.crud.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.angular.crud.app.model.Employee;
import com.angular.crud.app.repository.EmployeeRepository;

@RestController
@CrossOrigin
public class EmployeeRestController {

	public EmployeeRestController() {
		System.out.println("controller Run");
	}
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	
	@PostMapping("/add_employee")
	public @ResponseBody Employee saveEmployee(@RequestBody Employee employee) {
		
			try {
				Employee save = employeeRepository.save(employee);
				return save;
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to save employee: " + e.getMessage());
			}
	}
	
	@GetMapping("/all_employee")
	public @ResponseBody List<Employee> AllEmployee(){
		
		try {
			
			List<Employee> findAll = employeeRepository.findAll();
			
			System.out.println("helli" + findAll);
			
			return findAll;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to all employee: " + e.getMessage());
		}
		
		
	}
	
	@GetMapping("/deleteEmployee/{employeeId}")
	public void deleteEmployee(@PathVariable(value = "employeeId") int employeeId) {
		
		try {
			employeeRepository.deleteEmployee(employeeId);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to all employee: " + e.getMessage());
		}
	
	}
	
	
	

}
