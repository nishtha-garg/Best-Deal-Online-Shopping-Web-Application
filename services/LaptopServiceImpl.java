package services;

import java.util.Map;

import pojos.LaptopBean;
import daos.LaptopDAOImpl;
import daos.LaptopsDAO;

public class LaptopServiceImpl implements LaptopService{

private LaptopsDAO laptopsdao;
	

	
	public LaptopServiceImpl()
	{
		this.laptopsdao=new LaptopDAOImpl();
		
	}
	
	public Map<String, LaptopBean> laptopsList() {
	
		
		return laptopsdao.laptopsList();
	}

	
}
