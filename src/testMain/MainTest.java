package testMain;

import java.util.EnumSet;

import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import model.Gaiqing;
import model.HibernateUtils;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//one();
		two();
	}

	public static void one(){
		/**
		 * 根据hibernate.cfg.xml创建表
		 */
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
		SchemaExport schemaExport = new SchemaExport();
		schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
	}
	public static void two(){
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
