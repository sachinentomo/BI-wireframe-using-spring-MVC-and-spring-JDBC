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
public class DepartmentDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<Department> getDepartments(){
		String query = "select * from department where is_delete='0'";
		List<Department> departmentList = jdbcTemplate.query(query, new DepartmentRowMapper());
		return departmentList;
	}
	
	public Department getDepartment(int id)
	{
		String query = "select * from department where dept_id=? AND is_delete='0'";
		Department department =  jdbcTemplate.queryForObject(query,new DepartmentRowMapper(),id);
        return department;
	}
	
	public Department insertDepartment(Department department) {    
		String query = "insert into department (dept_code, dept_name, dept_desc, dept_loc) values (null,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

	    jdbcTemplate.update(connection -> {
	        PreparedStatement ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	          ps.setString(1, department.getDept_name());
	          ps.setString(2, department.getDept_desc());
	          ps.setString(3, department.getDept_loc());
	          
	          return ps;
	        }, keyHolder);
	    
	        int key = ((BigInteger) keyHolder.getKey()).intValue();
	        //System.out.println(key);
	        String dept_code="DEPT"+key;
	        String updateQuery = "update department set dept_code='"+dept_code+"' where dept_id='"+key+"'";
	        jdbcTemplate.update(updateQuery);
	        return getDepartment(key);
	}
	public boolean deleteDepartment(int id) {
		String query = "update department set is_delete='1' where dept_id='"+id+"'";
		int i = jdbcTemplate.update(query);
		boolean result = i>=1;
		return result;
		
	}
	
	public String updateDepartment(Department department) {
		System.out.println("Its working");
		String query = "update department set dept_name='"+department.getDept_name()+"', dept_desc='"+department.getDept_desc()+"', dept_loc='"+department.getDept_loc()+"' where dept_id='"+department.getDept_id()+"'";
		System.out.println(query);
		jdbcTemplate.update(query);
		//return getDepartment(department.getDept_id());
		return "";
	}
}
