package blue.liuk.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blue.liuk.base.BaseDao;
import blue.liuk.dao.ResourseDao;
import blue.liuk.exception.ErrorMsg;
import blue.liuk.exception.HrException;
import blue.liuk.model.Resourse;
import blue.liuk.service.ResourseService;
import blue.liuk.util.Page;
@Service
@Transactional
public class ResourseServiceImpl implements ResourseService {
	@Autowired
	private ResourseDao resourseDao;
	
	
	@Override
	public void delete(Integer id) {
		try {
			Resourse resourse=this.getById(id);
			resourseDao.delete(resourse);
		}
		catch (Exception e) {
			throw new HrException(ErrorMsg.DELETE_ERROR);
		}
	
	
	}
	@Override
	public void saveOrUpdate(Resourse resourse) {
		try {
			resourseDao.saveOrUpdate(resourse);
		}
		catch (Exception e) {
			throw new HrException(ErrorMsg.SAVE_ERROR);
		}
	}
	
	@Override
	public Resourse getById(Integer id) {
		if (null==id) {
			throw new HrException(ErrorMsg.ID_IS_NULL);
		}
		Resourse resourse=resourseDao.findById(Resourse.class, id);
		return resourse;
	}
	@Override
	public List<Resourse> getAll(Page p) {
		int total=resourseDao.getTotalCount(Resourse.class);
		p.setRowTotalCount(total);
		List<Resourse> resourses=resourseDao.findAll(Resourse.class, p.getRowStartCount(), Page.pagesize);
		return resourses;
	}
	@Override
	public List<Resourse> getAll() {
		List<Resourse> resourses=resourseDao.findAll(Resourse.class);
		return resourses;
	}
	
	@Override
	public List<Resourse> getAll(Integer[] ids) {
		List<Resourse> resourses=resourseDao.getAll(ids);
		return resourses;
	}
	
	@Override
	public List<Resourse> getByRoleNot(Integer roleid) {
		
		List<Resourse> resourses=resourseDao.getByRoleNot(roleid);
		return resourses;
	}
	
	@Override
	public List<Resourse> getByRole(Integer roleid) {
		
		List<Resourse> resourses=resourseDao.getByRole(roleid);
		return resourses;
	}
	
	@Override
	public List<Resourse> getByName(String name) {
		List<Resourse> resourses=resourseDao.findByProperty(Resourse.class, "name", name, BaseDao.EQUAL_SQL);
		return resourses;
	}
}
