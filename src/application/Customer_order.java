package application;

public class Customer_order {
	private int order_id;
	private int customer_id;
	private String order_date;
	
	public Customer_order(int order_id, int customer_id, String order_date) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.order_date = order_date;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	
	
	

}

