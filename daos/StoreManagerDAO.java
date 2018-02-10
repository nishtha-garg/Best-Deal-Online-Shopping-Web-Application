package daos;

public interface StoreManagerDAO {

	
	public boolean addProduct(String productid, String productretailer, double productprice, String producttype);
	public boolean deleteProduct(String productid);
	public boolean updateProduct(String productid, String productretailer, double productprice);
	
}
