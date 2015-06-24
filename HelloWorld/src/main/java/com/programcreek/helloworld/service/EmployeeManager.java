package com.programcreek.helloworld.service;

import java.util.ArrayList;
import java.util.List;

import com.programcreek.helloworld.exception.HelloWorldException;
import com.programcreek.helloworld.model.Employee;

public class EmployeeManager {
	private static List<Employee> employeeList;
	public EmployeeManager() {
		employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee("1", "Gopalakrishnan", "Jiju"));
		employeeList.add(new Employee("2","Sivankutty", "Saritha"));
		employeeList.add(new Employee("3","Sivankutty","Sangeetha"));
		employeeList.add(new Employee("4","Jiju krishnan","Abhinav"));
	}
	
	public List<Employee> getEmployeeList() throws HelloWorldException  {
		
		return employeeList;
	}
	
	public Employee addEmployee(Employee e){
		Employee employee = new Employee();
		employee.setId(employeeList.size() + 1 +"");
		employee.setFirstName(e.getFirstName());
		employee.setLastName(e.getLastName());
		employeeList.add(employee);
		return employee;
	}
}
