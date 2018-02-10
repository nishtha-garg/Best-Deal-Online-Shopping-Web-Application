package services;

import java.util.List;

import pojos.Order;
import pojos.Product;


public interface OrderService {
	

	List<Integer> insertOrders(String username,List<Product> productList);
	List<Order> orderListForUser(String username);
	
	int cancelOrder(int orderid);
	 List<Order> getAllOrders();
	 int deliverOrder(int orderid);

}
