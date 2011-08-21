package blue.liuk.db;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import blue.liuk.model.Employee;
import blue.liuk.model.InviteJob;
import blue.liuk.model.Notice;
import blue.liuk.model.Pay;
import blue.liuk.model.Resourse;
import blue.liuk.model.Role;
import blue.liuk.model.Train;
import blue.liuk.model.User;

public class Dbtest {

	@Test
	public void SchemaExport() {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {
			SchemaExport schemaExport = new SchemaExport(cfg);
			schemaExport.create(true, true);

			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			session.getTransaction().rollback();
		}
		finally {

		}

	}

	@Test
	public void addData() {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {

			for (int i = 0; i < 10; i++) {
				User user = new User();

				user.setUsername(i + "dd");
				session.save(user);
			}
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			session.getTransaction().rollback();
		}
		finally {

		}

	}

	@Test
	public void addData2() {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {

			for (int i = 0; i < 10; i++) {
				User user = new User();
				Role role = new Role();
				Resourse resourse = new Resourse();
				role.setName("role" + i);
				user.setUsername(i + "user");
				resourse.setName("res" + i);
				session.save(user);
				session.save(resourse);
				session.save(role);
				role.getResourses().add(resourse);
				user.getRoles().add(role);
				session.flush();

			}

			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			session.getTransaction().rollback();
		}
		finally {

		}

	}

	@Test
	public void addData3() {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {

			for (int i = 0; i < 10; i++) {

				Employee em = new Employee();

				em.setName("i" + "wo");
				em.setTelphone("100000" + i);
				session.save(em);
				Train train = new Train();
				train.setName(i * 2 + "train");
				train.setContent("liansini" + "i");

				train.getEmployees().add(em);
				session.save(train);
			}

			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			session.getTransaction().rollback();
		}
		finally {

		}

	}

	@Test
	public void addData4() {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {

			for (int i = 0; i < 10; i++) {
				Pay pay = new Pay();
				pay.setAccount(222222);
				pay.setAttendPay(new Long(10L));
				Employee em = new Employee();
				em.setName("wo");
				session.save(em);
				session.flush();
				pay.setEmployee(em);
				session.save(pay);

			}

			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			session.getTransaction().rollback();
		}
		finally {

		}

	}

	@Test
	public void addData5() {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {

			for (int i = 0; i < 10; i++) {
				Notice notice = new Notice();
				notice.setName("n" + i);
				notice.setContant("adf" + 1);

				session.save(notice);

			}

			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			session.getTransaction().rollback();
		}
		finally {

		}

	}
	
	@Test
	public void addData6() {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {

			for (int i = 0; i < 10; i++) {
				InviteJob inviteJob=new InviteJob();
				inviteJob.setName("haha"+i);
				inviteJob.setEducation("i");
				
				session.save(inviteJob);

			}

			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			session.getTransaction().rollback();
		}
		finally {

		}

	}
}
