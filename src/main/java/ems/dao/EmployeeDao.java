package ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.math.BigInteger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import ems.model.Employee;
@Component
public class EmployeeDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/*
	 * public int save(Employee employee){
	 * 
	 * } public int update(Employee employee){
	 * 
	 * } public int delete(int id){
	 * 
	 * } public Employee getEmpById(int id){
	 * 
	 * }
	 */   
	public List<Employee> getEmployees(){
		String query = "select * from employee where is_delete='0'";
		List<Employee> employeeList = jdbcTemplate.query(query, new EmployeeRowMapper());
		return employeeList;
	}
	
	    
	public Employee insertEmployee(Employee employee) {    
		String INSERT_MESSAGE_SQL = "insert into employee (emp_code,emp_name,emp_email,emp_pass,emp_dept,emp_prj,emp_join) values (null,?,?,?,?,?,now())";
		KeyHolder keyHolder = new GeneratedKeyHolder();

	    jdbcTemplate.update(connection -> {
	        PreparedStatement ps = connection.prepareStatement(INSERT_MESSAGE_SQL,Statement.RETURN_GENERATED_KEYS);
	          ps.setString(1, employee.getEmp_name());
	          ps.setString(2, employee.getEmp_email());
	          ps.setString(3, employee.getEmp_pass());
	          ps.setInt(4, employee.getEmp_dept());
	          ps.setInt(5, employee.getEmp_prj());
	          return ps;
	        }, keyHolder);
	    
	        int key = ((BigInteger) keyHolder.getKey()).intValue();
	        //System.out.println(key);
	        String emp_code="DEPT"+key;
	        String query = "update employee set emp_code='"+emp_code+"' where emp_id='"+key+"'";
	        jdbcTemplate.update(query);
	        return getEmployee(key);
	    }
	
	public Employee updateEmployee(Employee employee) {
		System.out.println("Its working");
		String query = "update employee set emp_name='"+employee.getEmp_name()+"', emp_email='"+employee.getEmp_email()+"', emp_pass='"+employee.getEmp_pass()+"', emp_dept='"+employee.getEmp_dept()+"', emp_prj='"+employee.getEmp_prj()+"' where emp_id='"+employee.getEmp_id()+"'";
		System.out.println(query);
		jdbcTemplate.update(query);
		return getEmployee(employee.getEmp_id());
		
	}
	public Employee getEmployee(int id)
	{
		String insert_fetch = "select * from employee where emp_id=? AND is_delete='0'";
        Employee employee =  jdbcTemplate.queryForObject(insert_fetch,new EmployeeRowMapper(),id);
        return employee;
	}
	public boolean deleteEmployee(int id) {
		String query = "update employee set is_delete='1' where emp_id='"+id+"'";
		int i = jdbcTemplate.update(query);
		boolean result = i>=1;
		return result;
		
	}
}


	