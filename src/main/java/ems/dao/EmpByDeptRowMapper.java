package ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.model.Department;
import ems.model.EmployeeByDepartment;

public class EmpByDeptRowMapper implements RowMapper<EmployeeByDepartment>{

	public EmployeeByDepartment mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeByDepartment test1 = new EmployeeByDepartment();
		test1.setCount(rs.getInt("count"));
		test1.setDept_name(rs.getString("dept_name"));
		return test1;
	}
	
}
