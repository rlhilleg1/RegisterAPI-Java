package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Employee;
import edu.uark.models.api.Product;
import edu.uark.models.entities.fieldnames.ProductFieldNames;

public class EmployeeEntity extends BaseEntity<EmployeeEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.password = rs.getString(ProductFieldNames.PASSWORD);
		this.status = rs.getString(ProductFieldNames.STATUS);
		this.EmployeeID = rs.getInt(ProductFieldNames.EMPLOYEEID);
		this.FirstName = rs.getString(ProductFieldNames.FIRSTNAME);
		this.LastName =  rs.getString(ProductFieldNames.LASTNAME);
		this.manager = rs.getString(ProductFieldNames.MANAGER);
		this.role = rs.getString(ProductFieldNames.ROLE);
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(ProductFieldNames.PASSWORD, this.password);
		record.put(ProductFieldNames.STATUS, this.status);
		record.put(ProductFieldNames.EMPLOYEEID, this.EmployeeID);
		record.put(ProductFieldNames.FIRSTNAME, this.FirstName);
		record.put(ProductFieldNames.LASTNAME, this.LastName);
		record.put(ProductFieldNames.MANAGER, this.manager);
		record.put(ProductFieldNames.ROLE, this.role);
		return record;
	}

	private String password;
	public String getPassword() {
		return this.password;
	}
	
	public EmployeeEntity setPassword(String password) {
		if(!StringUtils.equals(this.password, password)) {
			this.password = password;
			this.propertyChanged(ProductFieldNames.PASSWORD);
		}
		return this;
	}
	
	private String status;
	public String getStatus() {
		return this.status;
	}
	public EmployeeEntity setStatus(String status) {
		if(!StringUtils.equals(this.status, status)) {
			this.status = status;
			this.propertyChanged(ProductFieldNames.STATUS);
		}
		return this;
	}
	private String FirstName;
	public String getFirstName() {
		return this.FirstName;
	}
	public EmployeeEntity setFirstName(String FirstName) {
		if(!StringUtils.equals(this.FirstName, FirstName)) {
			this.FirstName = FirstName;
			this.propertyChanged(ProductFieldNames.FIRSTNAME);
		}
		return this;
	}
	private String LastName;
	public String getLastName() {
		return this.LastName;
	}
	public EmployeeEntity setLastName(String LastName) {
		if(!StringUtils.equals(this.LastName, LastName)) {
			this.LastName = LastName;
			this.propertyChanged(ProductFieldNames.LASTNAME);
		}
		return this;
	}
	private int EmployeeID;// CHECK
	public int getEmployeeID() {
		return this.EmployeeID;
	}
	public EmployeeEntity setEmployeeID(int EmployeeID) {
		if(this.EmployeeID != EmployeeID) {
			this.EmployeeID = EmployeeID;
			this.propertyChanged(ProductFieldNames.EMPLOYEEID);
		}
		return this;
	}
	private String role;
	public String getRole() {
		return this.role;
	}
	public EmployeeEntity setRole(String role) {
		if(!StringUtils.equals(this.role, role)) {
			this.role = role;
			this.propertyChanged(ProductFieldNames.ROLE);
		}
		return this;
	}
	
	private String manager;
	public String getManager() {
		return this.manager;
	}
	public EmployeeEntity setManager(String manager) {
		if(!StringUtils.equals(this.manager, manager)) {
			this.manager = manager;
			this.propertyChanged(ProductFieldNames.MANAGER);
		}
		return this;
	}
	
	
	/*public Employee synchronize(Employee apiEmployee) {
		//this.setCount(apiProduct.getCount());
		//this.setLookupCode(apiProduct.getLookupCode());
		this.setPassword(apiEmployee.getPassword());
		this.setStatus(apiEmployee.getStatus());
		apiEmployee.setId(this.getId());
		//apiProduct.setCreatedOn(this.getCreatedOn());
		
<<<<<<< HEAD
		return apiProduct;// Replace for employee
	}
=======
		return apiEmployee;
	}*/
>>>>>>> ab45c7d5ff86a6f8a96f152fc90f711d5a39d097
	
	public EmployeeEntity() {
		super(DatabaseTable.EMPLOYEE);
		this.password = StringUtils.EMPTY;
		this.status = StringUtils.EMPTY;
		this.EmployeeID = -1;
		this.FirstName = StringUtils.EMPTY;
		this.LastName = StringUtils.EMPTY;
		this.manager = StringUtils.EMPTY;
		this.role = StringUtils.EMPTY;
	}
	
	
	public EmployeeEntity(Employee apiEmployee) {
		super(DatabaseTable.EMPLOYEE);
		this.status = apiEmployee.getStatus();
		this.password = apiEmployee.getPassword();
		this.FirstName = apiEmployee.getFirstName();
		this.LastName = apiEmployee.getLastName();
		this.manager = apiEmployee.getManager();
		this.EmployeeID = apiEmployee.getEmployeeID();
		this.role = apiEmployee.getRole();

	}
}
