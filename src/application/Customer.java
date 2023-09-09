package application;

public class Customer {
	
	private int customer_id;
	private String customer_name;
	private String address;
	private String phone;
	
	
	


	public Customer( int customer_id, String customer_name, String address, String phone) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.address = address;
		this.phone = phone;
	}


	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}


	public String getCustomer_name() {
		return customer_name;
	}


	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
