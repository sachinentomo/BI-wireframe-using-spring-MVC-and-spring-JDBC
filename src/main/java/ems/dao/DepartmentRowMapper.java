package ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.model.Department;

public class DepartmentRowMapper implements RowMapper<Department>{

	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		Department department = new Department();
		department.setDept_id(rs.getInt(1));
		department.setDept_code(rs.getString(2));
		department.setDept_name(rs.getString(3));
		department.setDept_desc(rs.getString(4));
		department.setDept_loc(rs.getString(5));
		//department.setDept_count(rs.getInt("dept_count"));
		return department;
		
	}

}
