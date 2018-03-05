package edu.uark.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.employees.EmployeeByLookupCodeQuery;
import edu.uark.commands.products.ProductByLookupCodeQuery;
import edu.uark.commands.products.ProductCreateCommand;
import edu.uark.commands.products.ProductQuery;
//import edu.uark.commands.employee.EmployeeLogin;
import edu.uark.commands.products.ProductsQuery;

import edu.uark.models.api.Employee;
import edu.uark.commands.employees.EmployeeLogin;
import edu.uark.models.api.Product;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeRestController {
	
	//Let us recall that we can use the Product class as model, but 
	//the Employee class needs a different approach
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	//public List<Employee> getEmployees() {
	//	return (new EmployeeQuery()).execute();
	//}
	
	//@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	//public Employee getEmployee(@PathVariable UUID employeeId) {
	//	return (new EmployeeQuery()).
	//		setEmployeeId(employeeId).
	//		execute();
	//}

	/*@RequestMapping(value = "/byLookupCode/{employeeLookupCode}", method = RequestMethod.GET)
	public Employee getEmployeeByLookupCode(@PathVariable String employeeLookupCode) {
		return (new EmployeeByLookupCodeQuery()).
			setLookupCode(employeeLookupCode).
			execute();
	}*/
	
	//@RequestMapping(value = "/", method = RequestMethod.POST)
	//public Employee createEmployee(@RequestBody Employee employee) {
	//	return (new EmployeeCreateCommand()).
	//		setApiEmployee(employee).
	//		execute();
	//}
	
	/*@RequestMapping(value = "/{I}", method = RequestMethod.PUT)
	public Product updateProduct(@PathVariable UUID produId, @RequestBody Product product) {
		return (new ProductUpdateCommand()).
			setProductId(productId).
			setApiEmployee(employee).
			execute();
	}*/
	
@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Successful test. (EmployeeRestController)";
	}

@RequestMapping(value = "/login", method = RequestMethod.POST)
public Employee createEmployeeLogin(@RequestBody EmployeeLogin employee) {	
return (new EmployeeByLookupCodeQuery()).
		setEmployeeId(employee.getEmployeeId()).
		setPassword(DigestUtils.sha1Hex(employee.getPassword())).
		execute();
	}
}
