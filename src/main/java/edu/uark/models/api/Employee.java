package edu.uark.models.api;

import java.util.UUID;
import edu.uark.models.entities.EmployeeEntity; // CHANGE 

public class Employee {
	
	/*
	 3.) Define the classes to represent the input 
	 parameter and output result for #2. These will 
	 probably be modeled off of edu.uark.models.api:
	 Product. For example the input parameter will 
	 probably need fields: employee ID and password. 
	 The output result should contain all of the 
	 employee's details along with a status (e.g., successful login).
	  You will probably want to coordinate with 
	  the developer working on tracker 2.5 for your 
	  output result object definition.
	  */
	
	// Input: employee ID and password
	
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
	
	// Output: employee ID, password, status
	
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
	

}
