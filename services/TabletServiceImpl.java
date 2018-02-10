package services;

import java.util.Map;
import pojos.TabletBean;
import daos.TabletDAOImpl;
import daos.TabletDAO;
import daos.TabletDAO;
import daos.TabletDAOImpl;


public class TabletServiceImpl implements TabletService {

private TabletDAO tabletsdao;
	

	
	public TabletServiceImpl()
	{
		this.tabletsdao=new TabletDAOImpl();
		
	}
	
	public Map<String, TabletBean> tabletsList() {
	
		
		return tabletsdao.tabletsList();
	}

}
