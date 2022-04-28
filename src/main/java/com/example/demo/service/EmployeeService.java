package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> ftechAllEmployee();

	Employee updateEmployee(Employee employee, Integer empId);

	void deleteEmployeeById(Integer empId);

	Employee fetchEmployeeById(Integer empId);

}
