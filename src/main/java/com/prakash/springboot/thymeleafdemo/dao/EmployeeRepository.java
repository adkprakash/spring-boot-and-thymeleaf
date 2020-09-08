package com.prakash.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prakash.springboot.thymeleafdemo.entity.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it .. no need to write any code LOL!
	
	// add a method to sort by firstName
	public List<Employee> findByOrderByFirstName();
	
	@Query("FROM Employee e where e.firstName like %:theName% or e.lastName like %:theName%") 
	public List<Employee> doMyCustomSearch(@Param("theName") String theSearchName);
	
}
