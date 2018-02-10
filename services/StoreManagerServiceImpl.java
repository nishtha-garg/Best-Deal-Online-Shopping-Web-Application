package services;

import daos.StoreManagerDAO;
import daos.StoreManagerDAOImpl;

public class StoreManagerServiceImpl implements StoreManagerService {

	
private StoreManagerDAO storemanagerdao;
	
	
	public StoreManagerServiceImpl()
	{
		this.storemanagerdao=new StoreManagerDAOImpl();
		
	}
	
	public boolean addProduct(String productid, String productretailer, double productprice, String producttype)
	{
		return storemanagerdao.addProduct(productid, productretailer, productprice, producttype);
	}
	public boolean deleteProduct(String productid)
	{
		return storemanagerdao.deleteProduct(productid);
	}
	public boolean updateProduct(String productid, String productretailer, double productprice)
	{
		return storemanagerdao.updateProduct(productid, productretailer, productprice);
		
	}
}
