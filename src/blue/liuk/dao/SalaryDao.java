package blue.liuk.dao;

import java.util.List;
import java.util.Map;

import blue.liuk.base.CommDao;
import blue.liuk.model.Pay;
import blue.liuk.util.Page;


public interface  SalaryDao extends  CommDao<Pay, Integer>{
		public void delete(Pay sa);
		public void save(Pay sa);
		public void update(Pay sa);
		public Pay findById(int id);
		public List<Pay> search(Page p,Map<String, String> sw);
		public void searchByEmId(Page p, int id);
		public void searchByEmName(Page p, String name);
}
