package ems.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ems.model.Department;
import ems.model.TotalCount;
import ems.model.EmployeeByDepartment;
import ems.model.Project;

public class ReportDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public String getTotalCount() throws JsonProcessingException {
		String query = "SELECT (SELECT COUNT(emp_id) FROM   employee) AS emp_count, (SELECT COUNT(dept_id) FROM   department) AS dept_count, (SELECT count(prj_id) FROM project) AS prj_count FROM dual;";
		
		
		List<TotalCount> ltest = jdbcTemplate.query(query, new TotalCountRowMapper());
		ObjectMapper mapper = new ObjectMapper();
	    return mapper.writeValueAsString(ltest);
		//return ltest;
	}
	
	
	/*public String getEmployee() throws JsonProcessingException {
		String query = "select  e.emp_name, e.emp_code, d.dept_name, p.prj_name from employee e INNER JOIN department d ON e.emp_dept=d.dept_id INNER JOIN project p ON e.emp_prj=p.prj_id;";
		List<EmployeeProject,Department> ltest = jdbcTemplate.query(query, new EmployeeRowMapper());
		ObjectMapper mapper = new ObjectMapper();
	    return mapper.writeValueAsString(ltest);
	}*/
	
}
