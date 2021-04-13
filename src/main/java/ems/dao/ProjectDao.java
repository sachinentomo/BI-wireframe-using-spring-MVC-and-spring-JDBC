package ems.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import ems.model.Employee;
import ems.model.Project;
@Component
public class ProjectDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<Project> getProjects(){
		String query = "select * from project";
		List<Project> projectList = jdbcTemplate.query(query, new ProjectRowMapper());
		return projectList;
	}
}
