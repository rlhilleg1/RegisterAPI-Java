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
		//this.lookupCode = rs.getString(ProductFieldNames.LOOKUP_CODE);
		//this.count = rs.getInt(ProductFieldNames.COUNT);
		this.password = rs.getString(ProductFieldNames.PASSWORD);
		this.password = rs.getString(ProductFieldNames.STATUS);
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		//record.put(ProductFieldNames.LOOKUP_CODE, this.lookupCode);
		//record.put(ProductFieldNames.COUNT, this.count);
		record.put(ProductFieldNames.PASSWORD, this.password);
		record.put(ProductFieldNames.STATUS, this.status);
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
		return this.password;
	}
	public EmployeeEntity setStatus(String status) {
		if(!StringUtils.equals(this.password, password)) {
			this.status = status;
			this.propertyChanged(ProductFieldNames.STATUS);
		}
		return this;
	}
	
	public Employee synchronize(Employee apiEmployee) {
		//this.setCount(apiProduct.getCount());
		//this.setLookupCode(apiProduct.getLookupCode());
		this.setPassword(apiEmployee.getPassword());
		this.setStatus(apiEmployee.getStatus());
		apiEmployee.setId(this.getId());
		//apiProduct.setCreatedOn(this.getCreatedOn());
		
		return apiProduct;
	}
	
	public EmployeeEntity() {
		super(DatabaseTable.EMPLOYEE);
		this.password = StringUtils.EMPTY;
		this.status = StringUtils.EMPTY;
		//this.count = -1;
		//this.lookupCode = StringUtils.EMPTY;
	}
	
	public EmployeeEntity(Employee apiEmployee) {
		super(DatabaseTable.EMPLOYEE);
		this.status = apiEmployee.getStatus();
		this.password = apiEmployee.getPassword();
		//this.count = apiProduct.getCount();
		//this.lookupCode = apiProduct.getLookupCode();
	}

	/*private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public EmployeeEntity setLookupCode(String lookupCode) {
		if (!StringUtils.equals(this.lookupCode, lookupCode)) {
			this.lookupCode = lookupCode;
			this.propertyChanged(ProductFieldNames.LOOKUP_CODE);
		}
		
		return this;
	}*/

	/*private int count;
	public int getCount() {
		return this.count;
	}
	public EmployeeEntity setCount(int count) {
		if (this.count != count) {
			this.count = count;
			this.propertyChanged(ProductFieldNames.COUNT);
		}
		
		return this;
	}*/
}
