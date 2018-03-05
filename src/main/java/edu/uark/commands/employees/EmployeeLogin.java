/*package edu.uark.models.api;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

// Input object for 2.3

public class EmployeeLogin implements ResultCommandInterface < Employee > {
 private String employeeID;
 private Employee employeeObject;
 private EmployeeRepositoryInterface employeeRepository;

 @Override
 public Employee execute() {
  if (this.employeeObject == null) {
   throw new UnprocessableEntityException("Employee is null");
  }

  EmployeeEntity employeeEntity = this.employeeRepository.byRecordId(String.valueOf((employeeObject.getRecordId())));

  if (employeeEntity.getId() == employeeObject.getId() && employeeEntity.getPassword() == employeeObject.getPassword()) {
   return new Employee(employeeEntity);
  } else {
   throw new NotFoundException("Employee not found"); // Check message
  }
 }

 public EmployeeLogin() {
  this.employeeRepository = new EmployeeRepository(); // Repository will be added on 2.2
 }

 public EmployeeLogin setEmployeeID(Employee client) {
  this.employeeObject = employeeID;
  return this;
 }

 public Employee getEmployeeID() {
  return this.employeeID;
 }


 public EmployeeLogin setProductRepository(EmployeeRepositoryInterface employeeRepository) {
  this.employeeRepository = employeeRepository;
  return this;
 }

 public EmployeeRepositoryInterface getProductRepository() {
  return this.employeeRepository;
 }

}





/*public EmployeeLogin setEmployeeID(Employee client ) {
	return this.employeeID;	
}
	
public String getEmployeeID() {
	return this.employeeID;	
}*/

/*private String employeeID;
	
public EmployeeLogin setEmployeeID() {
	return this.employeeID;	
}
	
public String getEmployeeID() {
	return this.employeeID;	
}*/


