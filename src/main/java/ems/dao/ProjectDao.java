package ems.dao;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import ems.model.Department;
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
		String query = "select * from project where is_delete='0'";
		List<Project> projectList = jdbcTemplate.query(query, new ProjectRowMapper());
		return projectList;
	}
	
	public Project getProject(int id)
	{
		String query = "select * from project where prj_id=? AND is_delete='0'";
		Project project =  jdbcTemplate.queryForObject(query,new ProjectRowMapper(),id);
        return project;
	}
	
	public Project insertProject(Project project) {    
		String query = "insert into project (prj_code, prj_name, prj_desc) values (null,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

	    jdbcTemplate.update(connection -> {
	    	
	        PreparedStatement ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	          ps.setString(1, project.getPrj_name());
	          ps.setString(2, project.getPrj_desc());   
	          return ps;
	        }, keyHolder);
	    
	        int key = ((BigInteger) keyHolder.getKey()).intValue();
	        //System.out.println(key);
	        String prj_code="PRJ"+key;
	        String updateQuery = "update project set prj_code='"+prj_code+"' where prj_id='"+key+"'";
	        jdbcTemplate.update(updateQuery);
	        return getProject(key);
	}
	public boolean deleteProject(int id) {
		String query = "update project set is_delete='1' where prj_id='"+id+"'";
		int i = jdbcTemplate.update(query);
		boolean result = i>=1;
		return result;
		
	}
}
