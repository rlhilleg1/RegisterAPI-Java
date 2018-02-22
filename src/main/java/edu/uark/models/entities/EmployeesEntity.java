package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Employees;
//import edu.uark.models.entities.fieldnames.ProductFieldNames;
import edu.uark.models.api.Product;

public class EmployeesEntity extends BaseEntity<EmployeesEntity> {
	
	public Employees synchronize(Employees apiEmployees) {
		//this.setCount(apiProduct.getCount());
		//this.setLookupCode(apiProduct.getLookupCode());
		
		apiEmployees.setId(this.getId());
		
		return apiEmployees;
	}

}
