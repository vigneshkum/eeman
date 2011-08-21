/**
 * 
 */
package blue.liuk.db;

import java.util.Set;

import javax.persistence.FetchType;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import blue.liuk.action.SalaryAction;
import blue.liuk.dao.SalaryDao;
import blue.liuk.dao.impl.SalaryDaoImpl;
import blue.liuk.model.Employee;
import blue.liuk.model.Pay;
import blue.liuk.model.Reward;
import blue.liuk.model.Train;
import blue.liuk.service.EmployeeService;
import blue.liuk.service.impl.EmployeeServiceImpl;
import blue.liuk.util.Page;




/**
 * @author liuk
 */
public class PayTest {
	public Session getSession() {
		Configuration cfg = new Configuration();
		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		return sessionFactory.openSession();
	}
	@Test
	public void pay() {
		int id=71;
		Page p=new Page(1);
		Session session = this.getSession();
		session.beginTransaction();
		try {
			String sql="from Pay p where p.myeEmployee.id=? ";
			Query query=session.createQuery(sql);
			query.setParameter(0, id);
			p.setRowTotalCount(1);
			p.setList(query.list());
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		
		System.out.print(p.getList());
	}
	@Test
	public void sname() {
		int id=71;
		String name="仲王";
		Page p=new Page(1);
		Session session = this.getSession();
		session.beginTransaction();
		try {
			String sql="from Pay p where p.myeEmployee.name=? ";
			String sql2="select count(p.id) from Pay p where p.myeEmployee.name=? ";
			Query query2=session.createQuery(sql2);
			query2.setParameter(0, name);
			int count=((Long)query2.list().get(0)).intValue();
			p.setRowTotalCount(count);
			Query query=session.createQuery(sql);
			query.setParameter(0, name);
			query.setFirstResult(p.getRowStartCount());
			query.setMaxResults(Page.pagesize);
			p.setList(query.list());
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		
		System.out.print(p.getList());
	}
	@Test
	public void actiontestsa() {
		SalaryAction sa=new SalaryAction();
		sa.setSname("仲王");
		sa.searchByEmName();
		System.out.print(sa.getPagelist().getList());
	}
	@Test
	public void actiontestsid() {
		SalaryAction sa=new SalaryAction();
		sa.setId(71);
		sa.searchByEmId();
		System.out.print(sa.getPagelist().getList());
	}
	@Test
	public void actiontests() {
		SalaryAction sa=new SalaryAction();
		sa.setMaxid(200);
	sa.setMinid(70);
		sa.setSminbase("10");
		sa.setSmaxbase("2000");
		sa.setSminage("5");
		sa.setSmaxage("56");
		sa.setSname("仲王");
		//sa.search();
		System.out.print(sa.getPagelist().getList());
	}
}
