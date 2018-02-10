package pojos;


public class TabletBean extends Product {

	
	public TabletBean()
	{}
    
    public TabletBean(String productid, String productretailer, double productprice)
    {
		super(productid, productretailer, productprice);
    	
    }
   
    
    public TabletBean(String productid, String productretailer,
			double productprice, String productType) {
	 super(productid, productretailer, productprice, productType);	
    
	}
	
    
	
}