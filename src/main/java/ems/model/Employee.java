package ems.model;

import java.util.Date;

public class Employee {
	protected int emp_id;
	protected String emp_code;
	protected String emp_name;
	protected String emp_email;
	protected String emp_pass;
	protected int emp_dept;
	protected int emp_prj;
	protected Date emp_join;
	protected boolean is_delete;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int emp_id, String emp_code, String emp_name, String emp_email, String emp_pass, int emp_dept,
			int emp_prj, Date emp_join) {
		super();
		this.emp_id = emp_id;
		this.emp_code = emp_code;
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_pass = emp_pass;
		this.emp_dept = emp_dept;
		this.emp_prj = emp_prj;
		this.emp_join = emp_join;
	}
	public Employee(String emp_name, String emp_email, String emp_pass, int emp_dept, int emp_prj) {
		super();
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_pass = emp_pass;
		this.emp_dept = emp_dept;
		this.emp_prj = emp_prj;
		
	}
	
	public Employee(int emp_id, String emp_name, String emp_email, String emp_pass, int emp_dept, int emp_prj) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_pass = emp_pass;
		this.emp_dept = emp_dept;
		this.emp_prj = emp_prj;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getEmp_pass() {
		return emp_pass;
	}
	public void setEmp_pass(String emp_pass) {
		this.emp_pass = emp_pass;
	}
	public int getEmp_dept() {
		return emp_dept;
	}
	public void setEmp_dept(int emp_dept) {
		this.emp_dept = emp_dept;
	}
	public int getEmp_prj() {
		return emp_prj;
	}
	public void setEmp_prj(int emp_prj) {
		this.emp_prj = emp_prj;
	}
	public Date getEmp_join() {
		return emp_join;
	}
	public void setEmp_join(Date emp_join) {
		this.emp_join = emp_join;
	}
	public boolean isIs_delete() {
		return is_delete;
	}
	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}
	
	
}