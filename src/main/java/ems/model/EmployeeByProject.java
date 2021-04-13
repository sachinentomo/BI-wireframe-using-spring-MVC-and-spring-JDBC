package ems.model;

public class EmployeeByProject {
	String prj_name;
	int count;
	
	public EmployeeByProject(String prj_name, int count) {
		super();
		this.count = count;
		this.prj_name = prj_name;
	}
	public EmployeeByProject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPrj_name() {
		return prj_name;
	}
	public void setPrj_name(String prj_name) {
		this.prj_name = prj_name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}


