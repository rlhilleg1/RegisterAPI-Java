package edu.uark.controllers;

import java.util.List; // I am not sure if we need to use list for this class
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.products.ProductByLookupCodeQuery;
import edu.uark.commands.employee.EmployeeLogin;
import edu.uark.commands.products.ProductsQuery;

import edu.uark.models.api.Employee;
import edu.uark.models.api.Product;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeRestController {
	
	//Let us recall that we can use the Product class as model, but 
	//the Employee class needs a different approach
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Employee> () {
		return (new EmployeeQuery()).execute();
	}
	
	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable UUID emmployeeId) {
		return (new EmployeeQuery()).
			setEmployeeId(employeeId).
			execute();
	}

	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Product> getProducts() {
		return (new ProductsQuery()).execute();
	}*/

	@RequestMapping(value = "/{EmployeeId}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable UUID employeeId) {
		return (new EmployeeQuery()).
		setEmployeeId(employeeId).
		execute();
	}

	@RequestMapping(value = "/byLookupCode/{employeeLookupCode}", method = RequestMethod.GET)
	public Employee getEmployeeByLookupCode(@PathVariable String EmployeeLookupCode) {
		return (new EmployeeByLookupCodeQuery()).
			setLookupCode(EmployeeLookupCode). // See on Employee.Java
			execute();
	}*/
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)// changed
	public Employee createEmployee(@RequestBody Employee employee) 
	{// used different parameter
		return (new EmployeeCreateCommand()).
			setApiEmployee(employee).
			execute();
	}
	
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
}
