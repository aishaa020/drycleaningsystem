package application;

public class Item_instance {
	
	private int numberofitems;
	private int item_id;
	private int order_id;
	private int customer_id;
	private String service_type;
	private String item_type;
	private int service_cost;
	private int total_amount;
	
	
	public Item_instance( int item_id, int order_id, int customer_id, String service_type, String item_type, 
			int service_cost, int numberofitems, int total_amount) {
		super();
		this.item_id = item_id;
		this.numberofitems = numberofitems;
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.service_type = service_type;
		this.item_type = item_type;
		this.service_cost = service_cost;
		this.total_amount = total_amount;
	}
	
	public int getNumberofitems() {
		return numberofitems;
	}
	public void setNumberofitems(int numberofitems) {
		this.numberofitems = numberofitems;
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
	public String getService_type() {
		return service_type;
	}
	public void setService_type(String service_type) {
		this.service_type = service_type;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
	public int getService_cost() {
		return service_cost;
	}
	public void setService_cost(int service_cost) {
		this.service_cost = service_cost;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	
	
	
	
}	
	
