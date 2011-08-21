package blue.liuk.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import blue.liuk.base.BaseDao;
import blue.liuk.base.CommDaoImpl;
import blue.liuk.dao.RewardDao;
import blue.liuk.model.Reward;
import blue.liuk.util.Page;


/**
 * RewardDaoImpl use spring HibernateTemplate
 * 
 * @author liuk
 * @version 0.0.1
 */
@Component
public class RewardDaoImpl extends CommDaoImpl<Reward, Integer> implements RewardDao {
	Logger logger = Logger.getLogger(RewardDaoImpl.class);

	@Override
	public Reward findById(int id) {
		return super.findById(Reward.class, id);
	}

	@Override
	public void delete(Reward cj) {
		super.delete(cj);
	}

	@Override
	public void save(Reward cj) {
		super.saveOrUpdate(cj);
	}

	@Override
	public void update(Reward cj) {
		super.saveOrUpdate(cj);

	}

	@Override
	public List<Reward> findByTitle(Page p, String title) {
		title="%"+title+"%";
		int rowcount =getTotalCount(Reward.class, "title", title,BaseDao.LIKE_SQL);
		p.setRowTotalCount(rowcount);
		return findByProperty(Reward.class, "title", title, BaseDao.LIKE_SQL, p.getRowStartCount(), Page.pagesize);
	}

	@Override
	public List<Reward> findAll(Page p) {
		// hui
		int rowcount =getTotalCount(Reward.class);
		p.setRowTotalCount(rowcount);
	
		List<Reward> list=findAll(Reward.class, p.getRowStartCount(), Page.pagesize);
		return list;
	}

	@Override
	public List<Reward> search(Page p, Map<String, String> sw) {
		StringBuffer sws = new StringBuffer();
		if (sw.containsKey("minid")) {
			sws.append(" id  >= " + sw.get("minid") + " and ");
		}
		if (sw.containsKey("maxid")) {
			sws.append(" id  <= " + sw.get("maxid") + " and ");
		}

		if (sw.containsKey("stype")) {
			sws.append(" type like " + "'%" + sw.get("stype") + "%'" + " and ");
		}

		if (sw.containsKey("scontent")) {
			sws.append(" content like " + "'%" + sw.get("scontent") + "%'"
					+ " and ");
		}
		if (sw.containsKey("sminpenalty")) {
			sws.append(" penalty >= " + sw.get("sminpenalty") + " and ");
		}
		if (sw.containsKey("smaxpenalty")) {
			sws.append(" penalty <= " + sw.get("smaxpenalty") + " and ");
		}

		if (sw.containsKey("smintime")) {
			sws.append(" time >= " + "'" + sw.get("smintime") + "'" + " and ");
		}
		if (sw.containsKey("smaxtime")) {
			sws.append(" time <= " + "'" + sw.get("smaxtime") + "'" + " and ");
		}

		if (sws.toString().indexOf("and") == -1) {
			return this.findAll(p);
		} else {

			int kk = sws.lastIndexOf("and");
			final String sql = "from Reward p where" + sws.subSequence(0, kk);
			final String sql2 = "select count(p.id) from Reward p where"
					+ sws.subSequence(0, kk);

			logger.info(sql);
			int rowcount = ((Number) this.getHibernateTemplate().find(sql2)
					.get(0)).intValue();
			p.setRowTotalCount(rowcount);
			logger.info(sql);
			logger.info(rowcount);
			final int rs = p.getRowStartCount();
			final int ps = Page.pagesize;
			List res = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {
						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(sql);
							query.setFirstResult(rs);
							query.setMaxResults(ps);
							return query.list();
						}
					});
			return res;
		}

	}

}
