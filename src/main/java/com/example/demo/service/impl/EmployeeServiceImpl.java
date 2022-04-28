package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.InvalidFieldException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> ftechAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer empId) {
		employee.setEmpId(empId);
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Integer empId) {
		employeeRepository.deleteById(empId);		
	}

	@Override
	public Employee fetchEmployeeById(Integer empId) {
		Optional<Employee> employee = employeeRepository.findById(empId);
		if(employee.isPresent())
			return employee.get();
		else{
			throw new InvalidFieldException("No Employee Found with empId");
		}
	}
	

}
