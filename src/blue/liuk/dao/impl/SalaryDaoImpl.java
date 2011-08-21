package blue.liuk.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.sun.accessibility.internal.resources.accessibility;

import blue.liuk.base.BaseDao;
import blue.liuk.base.CommDaoImpl;
import blue.liuk.base.SpringBaseDao;
import blue.liuk.dao.SalaryDao;
import blue.liuk.model.Pay;
import blue.liuk.util.GetSth;
import blue.liuk.util.Page;

@Component
public class SalaryDaoImpl extends CommDaoImpl<Pay, Integer> implements SalaryDao {
	static Log logger = LogFactory.getLog(SalaryDaoImpl.class);



	@Override
	public void delete(Pay sa) {
		super.delete(sa);
	}

	@Override
	public void save(Pay sa) {
		this.getHibernateTemplate().save(sa);
	}

	@Override
	public void update(Pay sa) {
		this.getHibernateTemplate().update(sa);

	}

	@Override
	public Pay findById(int id) {
		return (Pay) this.getHibernateTemplate().get(Pay.class, id);
	}

	@Override
	public void searchByEmId(Page p, int id) {
		String sql = "from Pay p where p.employee.id=" + id;
		p.setRowTotalCount(1);
		@SuppressWarnings("unchecked")
		List<Pay> pays = (List<Pay>) this.getHibernateTemplate().executeFind(SpringBaseDao.hibernateCallback(sql, p.getRowStartCount(), Page.pagesize));
		p.setList(pays);
	}

	@Override
	public void searchByEmName(Page p, String name) {
		String sql = "from Pay p where p.employee.name=" + name;
		String sql2 = "select count(p.id) from Pay p where p.employee.name=" + name;
		int rowconut = ((Number) this.getHibernateTemplate().executeFind(SpringBaseDao.hibernateCallback(sql2,0,0)).get(0)).intValue();
		p.setRowTotalCount(rowconut);
		@SuppressWarnings("unchecked")
		List<Pay> pays = (List<Pay>) this.getHibernateTemplate().executeFind(SpringBaseDao.hibernateCallback(sql, p.getRowStartCount(), Page.pagesize));
		p.setList(pays);
	}

	@Override
	public List<Pay> search(Page p, Map<String, String> sw) {
		StringBuffer sws = new StringBuffer();
		if (sw.containsKey("minid")) {
			sws.append(" id  >= " + sw.get("minid") + " and ");
		}
		if (sw.containsKey("maxid")) {
			sws.append(" id  <= " + sw.get("maxid") + " and ");
		}

		if (sw.containsKey("sname")) {
			sws.append(" p.employee.name like " + "'%" + sw.get("sname") + "%'" + " and ");
		}

		if (sw.containsKey("sminbase")) {
			sws.append(" basePay >= " + sw.get("sminbase") + " and ");
		}
		if (sw.containsKey("smaxbase")) {
			sws.append(" basePay <= " + sw.get("smaxbase") + " and ");
		}

		if (sw.containsKey("sminage")) {
			// sws.append(" workAge >= " + sw.get("sminage") + " and ");
			sws.append(" p.employee.firstWorkTime <= " + "'" + GetSth.getDate(Integer.parseInt(sw.get("sminage"))) + "'" + " and ");
		}
		if (sw.containsKey("smaxage")) {
			// sws.append(" workAge <= " + sw.get("smaxage") + " and ");
			sws.append(" p.employee.firstWorkTime >= " + "'" + GetSth.getDate(Integer.parseInt(sw.get("smaxage"))) + "'" + " and ");
		}

		if (sw.containsKey("sminpt")) {
			sws.append(" time >= " + "'" + sw.get("sminpt") + "'" + " and ");
		}
		if (sw.containsKey("smaxpt")) {
			sws.append(" time <= " + "'" + sw.get("smaxpt") + "'" + " and ");
		}

		if (sws.toString().indexOf("and") == -1) {
			int count =getTotalCount(Pay.class);
			p.setRowTotalCount(count);
			return findAll(Pay.class, p.getRowStartCount(), Page.pagesize);
		} else {
			int kk = sws.lastIndexOf("and");
			String sql = "from Pay p where" + sws.subSequence(0, kk);
			String sql2 = "select count(p.id) from Pay p where" + sws.subSequence(0, kk);

			int rowconut = ((Number) this.getHibernateTemplate().executeFind(SpringBaseDao.hibernateCallback(sql2,0,0)).get(0)).intValue();
			p.setRowTotalCount(rowconut);
			@SuppressWarnings("unchecked")
			List<Pay> pays = (List<Pay>) this.getHibernateTemplate().executeFind(SpringBaseDao.hibernateCallback(sql, p.getRowStartCount(), Page.pagesize));
			return pays;
		}
	}

	


}
