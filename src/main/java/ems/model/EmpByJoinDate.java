package ems.model;
public class EmpByJoinDate {
	int count;
	String ejoin;
	public EmpByJoinDate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpByJoinDate(int count, String ejoin) {
		super();
		this.count = count;
		this.ejoin = ejoin;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getEjoin() {
		return ejoin;
	}
	public void setEjoin(String string) {
		this.ejoin = string;
	}
	
}
