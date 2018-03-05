package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import edu.uark.models.entities.EmployeeEntity;

public class Employee {
	
	public Employee() { // Constructor
		this.id = new UUID(0, 0);
		this.password = "";
		this.status = "";
		this.createdOn = LocalDateTime.now();
		this.firstname = "";
		this.lastname = "";
		this.manager = "";
		this.role = "";
	}
	
	public Employee(EmployeeEntity employeeEntity) {
		this.id = employeeEntity.getEmployeeID();
		this.password = employeeEntity.getPassword();
		this.status = employeeEntity.getStatus();
		this.createdOn = employeeEntity.getCreatedOn();
		this.firstname = employeeEntity.getFirstName();
		this.lastname = employeeEntity.getLastName();
		this.manager = employeeEntity.getManager();
		this.role = employeeEntity.getRole();
	}
	
	private UUID id;
	public UUID getEmployeeID() {
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
	
	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	public Employee setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	
	///////////////////////////////
	
	private String firstname;
	public String getFirstName() {
		return this.firstname;
	}
	public Employee setFirstName(String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	private String lastname;
	public String getLastName() {
		return this.lastname;
	}
	public Employee setLastName(String lastname) {
		this.lastname = lastname;
		return this;
	}
	
	private String manager;
	public String getManager() {
		return this.manager;
	}
	public Employee setManager(String manager) {
		this.manager = manager;
		return this;
	}
	
	private String role;
	public String getRole() {
		return this.role;
	}
	public Employee setRole(String role) {
		this.role = role;
		return this;
	}
	
	///////////////////////////////
	
	// Input: employee ID and password
	// Output: employee ID, password, status
}
