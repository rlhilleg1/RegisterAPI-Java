package edu.uark.controllers;

import java.util.List; // I am not sure if we need to use list for this class
//import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.products.ProductByLookupCodeQuery;
import edu.uark.commands.employee.EmployeeLogin;
//import edu.uark.commands.products.ProductsQuery;

import edu.uark.models.api.Employee;
import edu.uark.models.api.Product;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeRestController {
	
	//Let us recall that we can use the Product class as model, but 
	//the Employee class needs a different approach
	@RequestMapping(value = "/", method = RequestMethod.GET)
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Product> getProducts() {
		return (new ProductsQuery()).execute();
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable UUID productId) {
		return (new ProductQuery()).
			setProductId(productId).
			execute();
	}

	@RequestMapping(value = "/byLookupCode/{productLookupCode}", method = RequestMethod.GET)
	public Product getProductByLookupCode(@PathVariable String productLookupCode) {
		return (new ProductByLookupCodeQuery()).
			setLookupCode(productLookupCode).
			execute();
	}*/
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)// changed
	public Employee createEmployee(@RequestBody Product product) {// used different parameter
		return (new ProductCreateCommand()).
			setApiProduct(product).
			execute();
	}
	
	@RequestMapping(value = "/{I}", method = RequestMethod.PUT)
	public Product updateProduct(@PathVariable UUID productId, @RequestBody Product product) {
		return (new ProductUpdateCommand()).
			setProductId(productId).
			setApiProduct(product).
			execute();
	}
	
	/*@RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable UUID productId) {
		(new ProductDeleteCommand()).
			setProductId(productId).
			execute();
	}*/

	
@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Successful test. (EmployeeRestController)";
	}
}
