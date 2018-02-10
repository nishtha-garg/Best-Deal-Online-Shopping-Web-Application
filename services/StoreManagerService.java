package services;

public interface StoreManagerService {
	public boolean addProduct(String productid, String productretailer, double productprice, String producttype);
	public boolean deleteProduct(String productid);
	public boolean updateProduct(String productid, String productretailer, double productprice);
}
