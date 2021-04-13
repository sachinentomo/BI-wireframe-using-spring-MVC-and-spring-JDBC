package ems.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ems.model.EmpByJoinDate;
import ems.model.EmployeeByDepartment;
import ems.model.EmployeeByProject;

public class ResultDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public String getEmployeeByDepartment() throws JsonProcessingException {
		String query = "select count(emp_id) as count, d.dept_name from department d INNER JOIN employee e ON d.dept_id=e.emp_dept group by d.dept_name;";
		List<EmployeeByDepartment> ltest = jdbcTemplate.query(query, new EmpByDeptRowMapper());
		ObjectMapper mapper = new ObjectMapper();
	    return mapper.writeValueAsString(ltest);
	}
	
	public String getEmployeeByProject() throws JsonProcessingException {
		String query = "select count(emp_id) as count, p.prj_name from project p INNER JOIN employee e ON p.prj_id=e.emp_prj group by p.prj_name;";
		List<EmployeeByProject> ltest = jdbcTemplate.query(query, new EmpByPrjRowMapper());
		ObjectMapper mapper = new ObjectMapper();
	    return mapper.writeValueAsString(ltest);
	}
	
	public String getEmployeesByJoinDate() throws JsonProcessingException {
		String query = "select count(emp_id) as count, DATE_FORMAT(emp_join, '%d/%m/%Y') as ejoin from employee group by ejoin;";
		List<EmpByJoinDate> list = jdbcTemplate.query(query, new EmpByJoinDateRowMapper());
		ObjectMapper mapper = new ObjectMapper();
	    return mapper.writeValueAsString(list);
		
	}
}
