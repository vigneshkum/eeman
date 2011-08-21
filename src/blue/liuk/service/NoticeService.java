package blue.liuk.service;

import java.util.List;

import blue.liuk.model.Notice;
import blue.liuk.util.Page;

public interface NoticeService {


	void save(Notice notice);

	void saveOrUpdate(Notice notice);
	

	List<Notice> getAll(Page p);

	Notice getById(Integer id);

	void delete(Integer id);
	
	
	
}
