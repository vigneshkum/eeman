package blue.liuk.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import blue.liuk.base.CommDaoImpl;
import blue.liuk.dao.TrainDao;
import blue.liuk.model.Train;
import blue.liuk.util.MapUtil;

@Component
public class TrainDaoImpl extends CommDaoImpl<Train, Integer> implements TrainDao {
	static Log logger = LogFactory.getLog(TrainDaoImpl.class);

	@Override
	public List<Train> search(Map<String, String> params, int start, int limit) {

		List param = new ArrayList();
		String hql =makeHql(params,  param);
		if (hql.toString().indexOf("and") == -1) {
			return findAll(Train.class, start, limit);
		} else {
			int kk = hql.lastIndexOf("and");
			String sql1 = "from Train where" + hql.subSequence(0, kk);
			
			return findAll(sql1, param.toArray(), start, limit);
		}
	}

	@Override
	public int getTotalCount(Map<String, String> params) {

		List param = new ArrayList();
		
		String hql =makeHql(params,  param);
		if (hql.indexOf("and") == -1) {
			return getTotalCount(Train.class);
		} else {
			int kk = hql.lastIndexOf("and");
			String sql2 = "select count(t.id) from Train t where" + hql.subSequence(0, kk);
			int count=getTotalCount(sql2, param.toArray());
			return count;
		}
	}

	@SuppressWarnings("unchecked")
	private String makeHql2(Map<String, String> params,List param) {
		StringBuffer sql = new StringBuffer("");
		if (params.containsKey("id1") && !"".equals(params.get("id1"))) {
			sql.append(" id >="+params.get("id1").toString() + " and ");
			
		}
		if (params.containsKey("id2") && !"".equals(params.get("id2"))) {
			sql.append(" id <= "+params.get("id2").toString()+"  and ");
			
		}
		if (params.containsKey("content") && !"".equals(params.get("content"))) {
			sql.append(" content like "+"'%"+params.get("content").toString()+"%'" +"  and ");
	
		}
		if (MapUtil.checkUse(params, "title")) {
			sql.append(" title  like "+"'%"+params.get("title").toString()+"%'"+"  and ");
		}
		if (MapUtil.checkUse(params, "address")) {
			sql.append(" address  like "+"'%"+params.get("address").toString()+"%'"+"  and ");
		}
		return sql.toString();
	}
	@SuppressWarnings("unchecked")
	private String makeHql(Map<String, String> params,List param) {
		StringBuffer sql = new StringBuffer("");
		if (params.containsKey("id1") && !"".equals(params.get("id1"))) {
			sql.append(" id >= ?  and ");
			param.add( Integer.parseInt(params.get("id1").toString()));
		}
		if (params.containsKey("id2") && !"".equals(params.get("id2"))) {
			sql.append(" id <= ?  and ");
			param.add( Integer.parseInt(params.get("id2").toString()));
		}
		if (params.containsKey("content") && !"".equals(params.get("content"))) {
			sql.append(" content like ?  and ");
			param.add("%"+params.get("content").toString()+"%");
		}
		if (MapUtil.checkUse(params, "title")) {
			sql.append(" title  like ?  and ");
			param.add("%"+params.get("title").toString()+"%");
		}
		if (MapUtil.checkUse(params, "address")) {
			sql.append(" address  like ?  and ");
			param.add("%"+params.get("address").toString()+"%");
		}
		return sql.toString();
	}
}
