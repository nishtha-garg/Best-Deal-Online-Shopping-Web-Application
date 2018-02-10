package daos;

import java.util.Map;

import pojos.Product;

public interface CartDAO {

	Map<String, Product> getCartItems(String username);
	
	
}
