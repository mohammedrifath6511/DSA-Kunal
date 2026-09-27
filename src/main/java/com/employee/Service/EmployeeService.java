package com.employee.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.Model.Employee;
import com.employee.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	List<Employee> employees = new ArrayList<>();
	
	public List<Employee> getallEmployees() {
		return employees;
	}

	public List<Employee> getempById() {
		return employees;
	}

	public Employee getempByid(int id) {
			for(Employee emp : employees) {
				if(emp.getId() == id) {
					return emp;
				}
			}
		return null;
	}
	public void addemp(List<Employee> emp) {
		employeeRepository.saveAll(emp);
	}

	public List<Employee> getallemployees() {
		return employees;
	}

	public void updateempByid(Employee emp, int id) {
		for(Employee employee : employees) {
			if(employee.getId() == id) {
				employee.setSalary(emp.getSalary());
				employee.setDepartment(emp.getDepartment());
			}
		}
		
	}

	public boolean deleteempById(int id) {
		for(Employee employee : employees) {
			if(employee.getId() == id) {
				employees.remove(employee);
				return true;
			}
		}
		return false;
	}
}


