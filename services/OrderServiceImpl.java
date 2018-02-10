package services;

import java.util.List;

import pojos.Order;
import pojos.Product;
import daos.OrderDAO;
import daos.OrderDAOImpl;

public class OrderServiceImpl implements OrderService {

	
	private OrderDAO orderdao;
	
	public OrderServiceImpl()
	{
		orderdao=new OrderDAOImpl();
	}
	
public List<Integer> insertOrders(String username,List<Product> productList)
		{
			return orderdao.insertOrders(username, productList);
		}


public List<Order> orderListForUser(String username)
{
	return orderdao.orderListForUser(username);
}

public int cancelOrder(int orderid)
{
	return orderdao.cancelOrder(orderid);
}

	public List<Order> getAllOrders()
	{
		
		return orderdao.getAllOrders();
	}

	
	public int deliverOrder(int orderid)
	{
		return orderdao.deliverOrder(orderid);
	}
}

