package in.project.util;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;



public class HibernateUtil {
	
	static Configuration cfg=null;
	static SessionFactory sessionFactory=null;
	static Session session=null;
	
	private HibernateUtil() {
	}
	static {
		try {
			cfg=new Configuration();
			System.out.println( cfg.configure());
			sessionFactory=cfg.buildSessionFactory();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	public static Session getsession(){
		if(session==null) 
			session=sessionFactory.openSession();
		return session;
	}
	public static void closeSession() {
		if(session!=null) {
			session.close();
		}
	}
}
