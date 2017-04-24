package test;

import org.hibernate.Session;

import junit.framework.TestCase;
import model.Gaiqing;
import model.HibernateUtils;

public class TestAddCommit extends TestCase {

	public void testAdd() {
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();

			Gaiqing a = new Gaiqing();
			a.setName("guoaiqing");
			session.save(a);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
	}
}
