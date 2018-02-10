package daos;

import java.util.Map;

import pojos.TabletBean;

public interface TabletDAO {

	Map<String,TabletBean> tabletsList();
}
