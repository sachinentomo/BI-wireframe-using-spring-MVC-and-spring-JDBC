package ems.model;

public class Department {
	
	protected int dept_id;
	protected String dept_code;
	protected String dept_name;
	protected String dept_desc;
	protected String dept_loc;
	protected int dept_count;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Department(String dept_name, String dept_desc, String dept_loc) {
		super();
		this.dept_name = dept_name;
		this.dept_desc = dept_desc;
		this.dept_loc = dept_loc;
	}
	
	public Department(int dept_id, String dept_name, String dept_desc, String dept_loc) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.dept_desc = dept_desc;
		this.dept_loc = dept_loc;
	
	}

	public Department(int dept_id, String dept_code, String dept_name, String dept_desc, String dept_loc) {
		super();
		this.dept_id = dept_id;
		this.dept_code = dept_code;
		this.dept_name = dept_name;
		this.dept_desc = dept_desc;
		this.dept_loc = dept_loc;
	}
	

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_code() {
		return dept_code;
	}

	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDept_desc() {
		return dept_desc;
	}

	public void setDept_desc(String dept_desc) {
		this.dept_desc = dept_desc;
	}

	public String getDept_loc() {
		return dept_loc;
	}

	public void setDept_loc(String dept_loc) {
		this.dept_loc = dept_loc;
	}

	public int getDept_count() {
		return dept_count;
	}

	public void setDept_count(int dept_count) {
		this.dept_count = dept_count;
	}
	
	
	
	
	
	
}
	