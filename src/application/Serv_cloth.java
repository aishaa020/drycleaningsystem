package application;

public class Serv_cloth {
	
	private String service_type;
	private String item_type;
	private int service_cost;
	
	
	public Serv_cloth( String service_type, String item_type, int service_cost) {
		super();
		
		this.service_type = service_type;
		this.item_type = item_type;
		this.service_cost = service_cost;
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
	

}
