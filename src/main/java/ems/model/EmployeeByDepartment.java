package ems.model;

public class EmployeeByDepartment {
	String dept_name;
	int count;
	
	public EmployeeByDepartment(String dept_name, int count) {
		super();
		this.count = count;
		this.dept_name = dept_name;
	}
	public EmployeeByDepartment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
}
