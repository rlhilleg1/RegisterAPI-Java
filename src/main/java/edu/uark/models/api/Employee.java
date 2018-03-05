package edu.uark.models.api;

import java.util.UUID;
import edu.uark.models.entities.EmployeeEntity; // CHANGE 

public class Employee {
	
	public Employee() { // Constructor
		this.id = new UUID(0, 0);
		this.password = "";
		this.status = "";
	}
	
	public Employee(EmployeeEntity employeeEntity) {
		this.id = employeeEntity.getId();
		this.password = employeeEntity.getPassword();
		this.status = employeeEntity.getStatus();
	}
	
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Employee setId(UUID id) {
		this.id = id;
		return this;
	}
	
	private String password;
	public String getPassword() {
		return this.password;
	}
	public Employee setPassword(String password) {
		this.password = password;
		return this;
	}
	
	private String status;
	public String getStatus() {
		return this.status;
	}
	public Employee setStatus(String status) {
		this.status = status;
		return this;
	}
	
	// Input: employee ID and password
	// Output: employee ID, password, status
}
