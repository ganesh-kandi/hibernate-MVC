package in.project.second;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.project.Model.Employee;
import in.project.Util.HibernateUtil;

public class ConnectionPoolHikaricp {

	public static void main(String[] args) {
		
		
			 Session session=null;
			 Employee employee=null;
			 
			 try {
				session=HibernateUtil.getSession();
				 
					 employee=session.get(Employee.class, 1);
					 if(employee!=null) {
						 System.out.println(employee); 
						 System.out.println("inside employee");
					 }
					 
				 
			}catch(HibernateException he) {
				he.printStackTrace();
			} 
			 catch (Exception e) {
				e.printStackTrace();
			}
			 finally {
				 HibernateUtil.closeSession(session);
			 }
	}

}
