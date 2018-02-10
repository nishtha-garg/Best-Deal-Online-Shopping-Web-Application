package pojos;

import java.util.Date;

public class Order {

	private int orderid ;
	private String username ;
	private String productid ;
	private double productcost;
	private Date orderdate;
	private Date deliverydate;
	private String orderstatus;
	

	

	public Order() {
			
	}


	public Order(String username, String productid, double productcost) {
		
		this.username = username;
		this.productid = productid;
		this.productcost = productcost;
	}

	public Order(int orderid, String username, String productid,
			double productcost, Date orderdate, Date deliverydate,
			String orderstatus) {
		this.orderid = orderid;
		this.username = username;
		this.productid = productid;
		this.productcost = productcost;
		this.orderdate = orderdate;
		this.deliverydate = deliverydate;
		this.orderstatus = orderstatus;
	}



	public Date getOrderdate() {
		return orderdate;
	}


	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}


	public Date getDeliverydate() {
		return deliverydate;
	}


	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}


	public String getOrderstatus() {
		return orderstatus;
	}


	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}


	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getProductid() {
		return productid;
	}




	public void setProductid(String productid) {
		this.productid = productid;
	}




	public double getProductcost() {
		return productcost;
	}




	public void setProductcost(double productcost) {
		this.productcost = productcost;
	}

	
	
	
	
	
}
