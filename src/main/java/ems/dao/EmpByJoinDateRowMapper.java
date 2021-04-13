package ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.model.EmpByJoinDate;
import ems.model.EmployeeByProject;

	public class EmpByJoinDateRowMapper implements RowMapper<EmpByJoinDate>{
		public EmpByJoinDate mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpByJoinDate empByJoinDate = new EmpByJoinDate();
			empByJoinDate.setCount(rs.getInt("count"));
			empByJoinDate.setEjoin(rs.getString("ejoin"));
			return empByJoinDate;
		}

}
