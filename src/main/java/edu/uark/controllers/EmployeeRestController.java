package edu.uark.controllers;

//import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.employees.EmployeeLogin;
import edu.uark.models.api.Employee;
@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeRestController {
	
@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Successful test. (EmployeeRestController)";
	}

@RequestMapping(value = "/login", method = RequestMethod.POST)
public Employee createEmployeeLogin(@RequestBody EmployeeLogin employee) {	
	return (new EmployeeLogin()).
		setEmployeeID(employee.getEmployeeID()).
		setPassword((employee.getPassword())). //byteArrayToHexString needs to be implemented
		execute();
	}
}
