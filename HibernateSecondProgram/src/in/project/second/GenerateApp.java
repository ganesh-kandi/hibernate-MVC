package in.project.second;


import in.project.Model.Employee;
import in.project.Util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.*;

public class GenerateApp {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			session=HibernateUtil.getSession();
			if(session!=null) {
				transaction=session.beginTransaction();
				System.out.println("session obj is came...");
					if(transaction!=null){
						Employee employee=new Employee();
						employee.setEname("asdf");
						employee.setEsal(123);
						session.save(employee);
						flag=true;
					}
		}
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if(flag==true) {
				transaction.commit();
				System.out.println("successfully saved...");
			}
			else
				transaction.rollback();
		}
		
		HibernateUtil.closeSession(session);
		System.out.println("session closed...");
		
	}

}
