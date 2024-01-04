package com.angular.crud.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.angular.crud.app.model.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	@Transactional
	@Modifying
	@Query("delete from Employee where employeeId = :employeeId")
	public void deleteEmployee(int employeeId);
	
	
	

}
