package blue.liuk.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import blue.liuk.base.BaseDao;
import blue.liuk.base.CommDaoImpl;
import blue.liuk.base.SpringBaseDao;
import blue.liuk.dao.EmployeeDao;
import blue.liuk.model.Employee;
import blue.liuk.util.GetSth;
import blue.liuk.util.Page;


/**
 * EmployeeDaoImpl
 * 
 * @author liuk
 * @version 0.0.1
 * 
 */
@Component
public class EmployeeDaoImpl extends CommDaoImpl<Employee, Integer> implements EmployeeDao {
	// static Log logger = LogFactory.getLog(EmployeeDaoImpl.class);
	// log4j
	Logger logger = Logger.getLogger(EmployeeDaoImpl.class);

	public List<Employee> findAll() {
		@SuppressWarnings("unchecked")
		List<Employee> ems = (List<Employee>) this.getHibernateTemplate().executeFind(SpringBaseDao.hibernateCallback("from Employee",0,0));
		return ems;
	}

	@Override
	public void delete(Employee em) {
	super.delete(em);
	}

	@Override
	public void save(Employee em) {
		this.getHibernateTemplate().save(em);

	}

	@Override
	public void update(Employee em) {
		this.getHibernateTemplate().merge(em);
	}

	@Override
	public Employee findById(int id) {
		return (Employee) this.getHibernateTemplate().get(Employee.class, id);
	}
	@Override
	public List<Employee> findAll(int divid) {
		String sql = "select new Employee(em.id,em.name) from Employee em where em.department="+divid;
		@SuppressWarnings("unchecked")
		List<Employee> ems = (List<Employee>) this.getHibernateTemplate().executeFind(SpringBaseDao.hibernateCallback(sql,0,0));
		return ems;
	}

	@Override
	public List<Employee> findByName(Page p, String name) {
		int rowconut = getTotalCount(Employee.class, "name", "%"+name+"%", BaseDao.LIKE_SQL);
		p.setRowTotalCount(rowconut);
		return  findByProperty(Employee.class,"name", "%"+name+"%", BaseDao.LIKE_SQL, p.getRowStartCount(), Page.pagesize);
	}

	@Override
	public List<Employee> findByPhone(Page p, String phone) {
		String sql = "from Employee where telphone like " + phone;
		String sql2 = "select count(id) from Employee where telphone like " + phone;
		int rowconut = ((Number) this.getHibernateTemplate().executeFind(SpringBaseDao.hibernateCallback(sql2,0,0)).get(0)).intValue();
		p.setRowTotalCount(rowconut);
		@SuppressWarnings("unchecked")
		List<Employee> ems = (List<Employee>) this.getHibernateTemplate()
				.executeFind(SpringBaseDao.hibernateCallback(sql, p.getRowStartCount(), Page.pagesize));
		return ems;
	}

	@Override
	public List<Employee> search(Page p, Map<String, String> sw) {
	
		StringBuilder sws = new StringBuilder();
		if (null != sw.get("minid")) {
			sws.append(" id  >= " + sw.get("minid") + " and ");
		}
		if (sw.get("maxid") != null && !sw.get("maxid").isEmpty()) {
			sws.append(" id  <= " + sw.get("maxid") + " and ");
		}

		if (!sw.get("sname").isEmpty()) {
			sws.append(" name like " + "'%" + sw.get("sname") + "%'" + " and ");

		}

		if (!sw.get("sminage").isEmpty()) {
			sws.append(" birthday <= " + "'" + GetSth.getDate(Integer.parseInt(sw.get("sminage"))) + "'" + " and ");

		}
		if (!sw.get("smaxage").isEmpty()) {
			sws.append(" birthday >= " + "'" + GetSth.getDate(Integer.parseInt(sw.get("smaxage"))) + "'" + " and ");
		}

		if (!sw.get("sdiv").isEmpty()) {
			sws.append(" department.id = " + Integer.parseInt(sw.get("sdiv")) + " and ");
		}

		if (!sw.get("sedu").isEmpty()) {
			sws.append(" education like " + "'%" + sw.get("sedu") + "%'" + " and ");
		}
		if (!sw.get("sworkty").isEmpty()) {
			sws.append(" workType like " + "'%" + sw.get("sworkty") + "%'" + " and ");
		}
		if (!sw.get("sworkys").isEmpty()) {
			sws.append(" firstWorkTime <= " + "'" + GetSth.getDate(Integer.parseInt(sw.get("sworkys"))) + "'" + " and ");
		}

		if (sws.toString().indexOf("and") == -1) {
			return  this.findAll(p);
		} else {
			int kk = sws.lastIndexOf("and");
			String sql = "from Employee where" + sws.subSequence(0, kk);
			String sql2 = "select count(em.id) from Employee em where" + sws.subSequence(0, kk);
			int rowconut = ((Number) this.getHibernateTemplate().executeFind(SpringBaseDao.hibernateCallback(sql2,0,0)).get(0)).intValue();
			p.setRowTotalCount(rowconut);
			@SuppressWarnings("unchecked")
			List<Employee> ems = (List<Employee>) this.getHibernateTemplate().executeFind(
					SpringBaseDao.hibernateCallback(sql, p.getRowStartCount(), Page.pagesize));
			return ems;
		}
		
	}

	@Override
	public List<Employee> findAll(Page p) {
	
		int rowconut =super.getTotalCount(Employee.class);
		p.setRowTotalCount(rowconut);
	
		List<Employee> ems = (List<Employee>) super.findAll(Employee.class, p.getRowStartCount(), p.pagesize);
		return ems;

	}

}
