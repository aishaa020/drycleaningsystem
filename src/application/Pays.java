package application;

public class Pays {

	private int payment_id;
	private int customer_id;
	private int employee_id;
	private String payment_date;
	private int order_id;
	private String payment;
	private int bill_id;
	
	public Pays(int payment_id, int bill_id, int order_id, int customer_id, int employee_id, String payment_date,  String payment) {
		
		super();
		this.payment_id = payment_id;
		this.customer_id = customer_id;
		this.employee_id = employee_id;
		this.payment_date = payment_date;
		this.order_id = order_id;
		this.payment = payment;
		this.bill_id = bill_id;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	
}
