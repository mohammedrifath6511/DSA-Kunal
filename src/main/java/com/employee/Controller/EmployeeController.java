package com.employee.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.employee.Model.Employee;
import com.employee.Service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@PostMapping("/employees")
	public ResponseEntity<String> addemp(@RequestBody List<Employee> emp){
		service.addemp(emp);
		return ResponseEntity.status(HttpStatus.CREATED).body("Employees are created");
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getallemployees(){
		List<Employee> empById = service.getallemployees();
		return ResponseEntity.ok().body(empById);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<?> getempByid(@PathVariable int id){
		Employee empById = service.getempByid(id);
		if(empById == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such employee exist");
		}
		return ResponseEntity.ok().body(empById);
	}
	
	@PutMapping("employees/{id}")
	public ResponseEntity<String> updateempById(@RequestBody Employee emp, @PathVariable int id){
		service.updateempByid(emp, id);
		return ResponseEntity.ok().body("Employee id:" + id + " have been updated ");
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteempById(@PathVariable int id){
		boolean deletedemp = service.deleteempById(id);
		if(deletedemp) return ResponseEntity.ok()
				.body("employee deleted");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not employee found");
	}
}