package blue.liuk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blue.liuk.dao.NoticeDao;
import blue.liuk.model.Notice;
import blue.liuk.service.NoticeService;
import blue.liuk.util.Page;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;

	@Override
	public void delete(Integer id) {
		Notice notice=this.getById(id);
		noticeDao.delete(notice);
	}

	@Override
	public void save(Notice notice) {
		noticeDao.save(notice);

	}

	@Override
	public void saveOrUpdate(Notice notice) {
	noticeDao.saveOrUpdate(notice);

	}
	@Override
	public Notice getById(Integer id) {
		return noticeDao.findById(Notice.class, id);
	}

	@Override
	public List<Notice> getAll(Page p) {
		int count=noticeDao.getTotalCount(Notice.class);
		p.setRowTotalCount(count);
		List<Notice> notices=noticeDao.findAll(Notice.class, p.getRowStartCount(), Page.pagesize);
		return notices;
	}

}
