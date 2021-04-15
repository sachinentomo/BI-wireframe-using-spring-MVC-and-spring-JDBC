package ems.model;

public class TotalCount {
	int emp_count;
	int dept_count;
	int prj_count;
	public TotalCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TotalCount(int emp_count, int dept_count, int prj_count) {
		super();
		this.emp_count = emp_count;
		this.dept_count = dept_count;
		this.prj_count = prj_count;
	}
	public int getEmp_count() {
		return emp_count;
	}
	public void setEmp_count(int emp_count) {
		this.emp_count = emp_count;
	}
	public int getDept_count() {
		return dept_count;
	}
	public void setDept_count(int dept_count) {
		this.dept_count = dept_count;
	}
	public int getPrj_count() {
		return prj_count;
	}
	public void setPrj_count(int prj_count) {
		this.prj_count = prj_count;
	}
	
	
}
