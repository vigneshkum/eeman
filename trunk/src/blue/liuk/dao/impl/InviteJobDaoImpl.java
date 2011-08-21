package blue.liuk.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import blue.liuk.base.CommDaoImpl;
import blue.liuk.dao.InviteJobDao;
import blue.liuk.model.InviteJob;
import blue.liuk.util.MapUtil;
import blue.liuk.util.Page;

@Component
public class InviteJobDaoImpl extends CommDaoImpl<InviteJob, Integer> implements InviteJobDao {
	static Log logger = LogFactory.getLog(InviteJobDaoImpl.class);

	@Override
	public List<InviteJob> search(Page pagelist, Map<String, String> sw) {
		List<String> param = new ArrayList<String>();
		String hql = null;
		this.makeHql(sw, hql, param);
		if (hql.indexOf("like") == -1) {
			hql = "from InviteJob";

		} else {
			int kk = hql.lastIndexOf("and");
			hql = "from InviteJob t where " + hql.subSequence(0, kk);
		}
		return null;
	}

	private void makeHql(Map<String, String> sw, String hql, List<String> param) {
		StringBuilder sb = new StringBuilder();
		if (!sw.get("name").isEmpty()) {
			sb.append(" name like ? and ");
			param.add("%" + sw.get("name") + "%");
		}
		if (sw.containsKey("birth")) {
			sb.append(" birthday like ? and ");
			param.add("%" + sw.get("birth") + "%");
		}
		if (!sw.get("profession").isEmpty()) {
			sb.append(" profession like  ? and ");
			param.add("%" + sw.get("profession") + "%");
		}
		if (!sw.get("education").isEmpty()) {
			sb.append(" education like ? and ");
			param.add("%" + sw.get("education") + "%");
		}

	}

}