package ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.model.EmployeeByProject;

public class EmpByPrjRowMapper implements RowMapper<EmployeeByProject>{
	public EmployeeByProject mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeByProject empByPrj = new EmployeeByProject();
		empByPrj.setCount(rs.getInt("count"));
		empByPrj.setPrj_name(rs.getString("prj_name"));
		return empByPrj;
	}

}
