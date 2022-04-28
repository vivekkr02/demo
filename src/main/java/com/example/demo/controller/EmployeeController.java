package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.exception.InvalidFieldException;
import com.example.demo.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	// save new employee details
	 @PostMapping("/")
	 public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
		 if(employee ==  null){
			 throw new InvalidFieldException("Input field in Empty");
		 }
		 return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	 }
	 
	// fetch all employee details list
	 @GetMapping("/")
	 public ResponseEntity<List<Employee>> fetchAllEmployee(){
		 return new ResponseEntity<List<Employee>>(employeeService.ftechAllEmployee(), HttpStatus.OK);
	 }
	 
	// fetch employee details by empId
	 @GetMapping("/{empId}")
	 public ResponseEntity<Employee> fetchEmployeeById(@PathVariable("empId") Integer empId){
		 return new ResponseEntity<Employee>(employeeService.fetchEmployeeById(empId), HttpStatus.OK);
	 }
	 
	// update employee details
	 @PutMapping("/{empId}")
	 public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee, @PathVariable("empId") Integer empId){
		 if(employee ==  null){
			 throw new InvalidFieldException("Input field in Empty");
		 }
		 return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, empId),HttpStatus.CREATED);
	 }
	 
	// delete employee details by empId
	 @DeleteMapping("/{empId}")
	 public ResponseEntity<Void> deleteDepartmentById(@PathVariable("empId") Integer empId){
		 employeeService.deleteEmployeeById(empId);
		 return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	 }

}
