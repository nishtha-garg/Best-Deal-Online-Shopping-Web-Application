package pojos;

public class LaptopBean extends Product {

	public LaptopBean()
	{}
    
    public LaptopBean(String productid, String productretailer, double productprice)
    {
		super(productid, productretailer, productprice);
    	
    }

	public LaptopBean(String productid, String productretailer,
			double productprice, String productType) {
	 super(productid, productretailer, productprice, productType);	
    
	}
}