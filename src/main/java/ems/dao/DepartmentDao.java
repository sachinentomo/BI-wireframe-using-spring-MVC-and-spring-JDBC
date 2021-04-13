package ems.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import ems.model.Department;
import ems.model.Project;
@Component
public class DepartmentDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<Department> getDepartments(){
		String query = "select * from department";
		List<Department> departmentList = jdbcTemplate.query(query, new DepartmentRowMapper());
		return departmentList;
	}
}
