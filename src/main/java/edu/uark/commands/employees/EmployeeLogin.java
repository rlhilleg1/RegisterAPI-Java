package edu.uark.commands.employees;

// CLASS IS THE SAME AS PRODUCT UPDATE

import java.util.UUID;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

import org.apache.commons.lang3.StringUtils;


public class EmployeeLogin implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {
		//Validations
		if (StringUtils.isBlank(this.apiEmployee.getEmployeeID())) {
			throw new UnprocessableEntityException("EmployeeID");
		}

		EmployeeEntity employeeEntity = this.employeeRepository.get(this.employeeID);
		if (employeeEntity == null) { //No record with the associated record ID exists in the database.
			throw new NotFoundException("Employee");
		}
		
		// WE ARE NOT USING "synchronize" CLASS
		//this.apiEmployee = employeeEntity.synchronize(this.apiEmployee); //Synchronize any incoming changes for UPDATE to the database.
		
		employeeEntity.save(); //Write, via an UPDATE, any changes to the database.
		
		return this.apiEmployee;
	}

	//Properties
	private UUID employeeID;
	public UUID getEmployeeID() {
		return this.employeeID;
	}
	public EmployeeLogin setEmployeeID(UUID employeeID) {
		this.employeeID = employeeID;
		return this;
	}
	
	private String password;
	public String getPassword() {
		return this.password;
	}
	public EmployeeLogin setPassword(String password) {
		//this.password = byteArrayToHexString(password);
		this.password = (password);
		return this;
	}
	
	private Employee apiEmployee;
	public Employee getApiEmployee() {
		return this.apiEmployee;
	}
	public EmployeeLogin setApiEmployee(Employee apiEmployee) {
		this.apiEmployee = apiEmployee;
		return this;
	}
	
	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getEmployeeRepository() {
		return this.employeeRepository;
	}
	public EmployeeLogin setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public EmployeeLogin() {
		this.employeeRepository = new EmployeeRepository();
	}
}
