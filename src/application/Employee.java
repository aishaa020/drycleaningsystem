package application;

public class Employee {

	private int employee_id;
	private String employee_name;
	
	
	public Employee(int employee_id, String employee_name) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
	}


	public int getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	public String getEmployee_name() {
		return employee_name;
	}


	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	
	
	
}
