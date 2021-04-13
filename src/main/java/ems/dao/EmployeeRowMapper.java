package ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.model.Employee;



public class EmployeeRowMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmp_id(rs.getInt(1));
		employee.setEmp_code(rs.getString(2));
		employee.setEmp_name(rs.getString(3));
		employee.setEmp_email(rs.getString(4));
		employee.setEmp_pass(rs.getString(5));
		employee.setEmp_dept(rs.getInt(6));
		employee.setEmp_prj(rs.getInt(7));
		employee.setEmp_join(rs.getDate(8));
		return employee;
	}

}
