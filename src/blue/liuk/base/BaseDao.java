package blue.liuk.base;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
/**
 * basedao，主要实现了各个基于注解的hibernate dao的注入。
 * 所有的dao集成此类，使用spring来管理
 * @author liuk
 * @return the hibernateTemplate
 * @version 0.1
 */

@Component
public class BaseDao {
	public static String EQUAL_SQL=" = ? ";
	public static String NOT_EQUAL_SQL=" != ? ";
	public static String LIKE_SQL=" like ? ";
	/**
	 * 由spring自动注入
	 * @author liuk
	 *
	 */
	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * 各子类可以直接由此调用HibernateTemplate
	 * @author liuk
	 *
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

}
