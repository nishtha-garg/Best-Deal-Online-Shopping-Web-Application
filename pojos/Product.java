package pojos;
import java.util.ArrayList;
import java.util.List;

public class Product {

	private String productid;
	private String productretailer;
	private double productprice;
    
    private String productType;
   
    	public Product()
    	{}
    
    
    public Product(String productid, String productretailer, double productprice)
    {
		this.productid = productid;
    	this.productretailer = productretailer;
    	this.productprice = productprice;
    	
    }

    
    
    
    
	public Product(String productid, String productretailer) {
		super();
		this.productid = productid;
		this.productretailer = productretailer;
	}


	public Product(String productid, String productretailer,
			double productprice, String productType) {
		
		this.productid = productid;
		this.productretailer = productretailer;
		this.productprice = productprice;
		this.productType = productType;
	}


	public String getProductRetailer() {
		return productretailer;
	}

	public void setProductRetailer(String productretailer) {
		this.productretailer = productretailer;
	}

	

	public String getProductId() {
		return productid;
	}

	public void setProductId(String id) {
		this.productid = productid;
	}

	
	public double getProductPrice() {
		return productprice;
	}

	public void setProductPrice(double productprice) {
		this.productprice = productprice;
	}


	public String getProductType() {
		return productType;
	}


	public void setProductType(String productType) {
		this.productType = productType;
	}


	
	public String toString() {
		return "Product [productid=" + productid + ", productretailer="
				+ productretailer + ", productprice=" + productprice
				+ ", productType=" + productType + "]";
	}

    
	
}