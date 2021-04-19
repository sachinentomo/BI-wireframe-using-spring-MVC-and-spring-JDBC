package ems.model;

public class Project {
	protected int prj_id;
	protected String prj_code;
	protected String prj_name;
	protected String prj_desc;
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(int prj_id, String prj_code, String prj_name, String prj_desc) {
		super();
		this.prj_id = prj_id;
		this.prj_code = prj_code;
		this.prj_name = prj_name;
		this.prj_desc = prj_desc;
	}
	
	public Project(int prj_id, String prj_name, String prj_desc) {
		super();
		this.prj_id = prj_id;
		this.prj_name = prj_name;
		this.prj_desc = prj_desc;
	}
	public Project(String prj_name, String prj_desc) {
		super();
		this.prj_name = prj_name;
		this.prj_desc = prj_desc;
	}
	public int getPrj_id() {
		return prj_id;
	}
	public void setPrj_id(int prj_id) {
		this.prj_id = prj_id;
	}
	public String getPrj_code() {
		return prj_code;
	}
	public void setPrj_code(String prj_code) {
		this.prj_code = prj_code;
	}
	public String getPrj_name() {
		return prj_name;
	}
	public void setPrj_name(String prj_name) {
		this.prj_name = prj_name;
	}
	public String getPrj_desc() {
		return prj_desc;
	}
	public void setPrj_desc(String prj_desc) {
		this.prj_desc = prj_desc;
	}
	
	
}
