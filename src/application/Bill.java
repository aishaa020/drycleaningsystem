package application;

public class Bill {

	private int bill_id;
	private int amount;
	private int customer_id;
	private int order_id;
	
	
	
	
	public Bill(int bill_id, int order_id, int customer_id, int amount) {
		super();
		this.bill_id = bill_id;
		this.amount = amount;
		this.customer_id = customer_id;
		this.order_id = order_id;
		
	}



	public int getBill_id() {
		return bill_id;
	}



	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}



	public int getCustomer_id() {
		return customer_id;
	}



	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}



	public int getOrder_id() {
		return order_id;
	}



	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}



	
	
}
