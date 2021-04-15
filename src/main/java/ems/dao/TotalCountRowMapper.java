package ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import ems.model.TotalCount;

public class TotalCountRowMapper implements RowMapper<TotalCount>{

	@Override
	public TotalCount mapRow(ResultSet rs, int rowNum) throws SQLException {
		TotalCount tc = new TotalCount();
		
		tc.setEmp_count(rs.getInt("emp_count"));
		tc.setDept_count(rs.getInt("dept_count"));
		tc.setPrj_count(rs.getInt("prj_count"));
		return tc;
	}
	
}
