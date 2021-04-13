package ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.model.Project;

public class ProjectRowMapper implements RowMapper<Project>{

	public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
		Project project = new Project();
		project.setPrj_id(rs.getInt(1));
		project.setPrj_code(rs.getString(2));
		project.setPrj_name(rs.getString(3));
		project.setPrj_desc(rs.getString(4));
		return project;
		
		
	}
	
}
