package blue.liuk.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import blue.liuk.base.BaseDao;
import blue.liuk.dao.InviteJobDao;
import blue.liuk.exception.ErrorMsg;
import blue.liuk.exception.ExceptionMsg;
import blue.liuk.exception.HrException;
import blue.liuk.model.Employee;
import blue.liuk.model.InviteJob;
import blue.liuk.service.EmployeeService;
import blue.liuk.service.InviteJobService;
import blue.liuk.util.Page;

@Transactional
@Component
public class InviteJobServiceImpl implements InviteJobService {
	@Autowired
	private InviteJobDao inviteJobDao;
	@Autowired
	private EmployeeService employeeService;

	@Override
	public void add(InviteJob invite) {
		try {
			inviteJobDao.saveOrUpdate(invite);
		}
		catch (Exception e) {
			throw new HrException(ErrorMsg.SAVE_ERROR);
		}

	}

	@Override
	public void modify(InviteJob invite) {
		try {
			inviteJobDao.saveOrUpdate(invite);
		}
		catch (Exception e) {
			throw new HrException(ErrorMsg.SAVE_ERROR);
		}
	}

	@Override
	public InviteJob findById(int id) {
		if (null == new Integer(id)) {
			throw new HrException(ErrorMsg.ID_IS_NULL);
		}
		InviteJob inviteJob = inviteJobDao.findById(InviteJob.class, id);
		if (null == inviteJob) {
			throw new HrException(ErrorMsg.ID_FIND_NO);
		}
		return inviteJob;

	}
	@Override
	public List<InviteJob> findByName(Page page,String name) {
		int count=inviteJobDao.getTotalCount(InviteJob.class, "name", "%"+name+"%", BaseDao.LIKE_SQL);
		page.setRowTotalCount(count);
		List<InviteJob> inviteJobs=inviteJobDao.findByProperty(InviteJob.class, "name", "%"+name+"%", BaseDao.LIKE_SQL, page.getRowStartCount(), Page.pagesize);
		if (inviteJobs.size()==0) {
			throw new HrException(ErrorMsg.NO_RESULT);
		}
		return inviteJobs;

	}

	@Override
	public void delete(int id) {
		InviteJob em = inviteJobDao.findById(InviteJob.class, id);
		try {
			inviteJobDao.delete(em);
		}
		catch (Exception e) {
			throw new HrException(ErrorMsg.DELETE_ERROR);
		}
	}

	@Override
	public void deleteMore(int[] ids) {
		try {
			for (int id : ids) {
				InviteJob em = inviteJobDao.findById(InviteJob.class, id);
				inviteJobDao.delete(em);
			}
		}
		catch (Exception e) {
			throw new HrException(ErrorMsg.DELETE_ERROR);
		}
		

	}

	@Override
	public List<InviteJob> getAll(Page page ) {
		int 	total=inviteJobDao.getTotalCount(InviteJob.class);
		page.setRowTotalCount(total);
		
		return inviteJobDao.findAll(InviteJob.class, page.getRowStartCount(), Page.pagesize);
	}

	@Override
	public List<InviteJob> search(Page pagelist, Map<String, String> sw) {
		
		return inviteJobDao.search(pagelist, sw);
	}

	@Override
	public List<InviteJob> getByVer(Page pagelist, Integer ver) {
		int 	total=inviteJobDao.getTotalCount(InviteJob.class, "isEmploied", ver,BaseDao.EQUAL_SQL);
		pagelist.setRowTotalCount(total);
		List<InviteJob> inviteJobs=inviteJobDao.findByProperty(InviteJob.class, "isEmploied", ver, BaseDao.EQUAL_SQL, pagelist.getRowStartCount(), Page.pagesize);
		return inviteJobs;
	}
	@Override
	public Employee change(Integer id){
		InviteJob inviteJob = this.findById(id);
		if (null==inviteJob.getIsEmploied()||inviteJob.getIsEmploied()!=1) {
			throw new HrException(ErrorMsg.NO_CHECK);
		}
		
		Employee employee=new Employee();
		employee.setName(inviteJob.getName());
		employee.setBirthday(inviteJob.getBirthday());
		employee.setSex(inviteJob.getSex());
		employeeService.add(employee);
		inviteJobDao.delete(inviteJob);
		return 	employee;
	}
	

}
