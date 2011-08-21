package blue.liuk.service;

import java.util.List;
import java.util.Map;

import blue.liuk.model.Pay;
import blue.liuk.util.Page;


public interface  SalaryService {
		public void delete(int id);
		public void add(Pay sa);
		public void modify(Pay sa);
		public Pay findById(int id);
		public List<Pay> search(Page p,Map<String, String> sw);
		List<Pay>  searchByEmId(Page p, int id);
		List<Pay>  searchByEmname(Page p, String n);
		void add(Pay sa, Integer emid);
		void modify(Pay sa, Integer emid);
		List<Pay> findAll(Page p);
}
