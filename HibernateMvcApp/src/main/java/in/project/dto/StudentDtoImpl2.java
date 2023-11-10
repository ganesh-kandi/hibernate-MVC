package in.project.dto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.project.Model.Student;
import in.project.util.HibernateUtil;
import in.project.util.JdbcUtil;

public class StudentDtoImpl2 implements IStudentDto {

	
	Connection connection;
	PreparedStatement pstmt;
	
	
	Session session=null;
	Transaction transaction=null;
	Request request=null;
	boolean flag=true;
	String status=null;
	
	@Override
	public String save(Student student) {
		
		
//		String SqlQuery="insert into student (`name`,`email`,`city`,`country`) values(?,?,?,?)";
//		try {
//			connection= JdbcUtil.getConnnection();
//			
//			if(connection!=null) {
//				pstmt=connection.prepareStatement(SqlQuery);
//				pstmt.setString(1, student.getName());
//				pstmt.setString(2, student.getEmail());
//				pstmt.setString(3, student.getCity());
//				pstmt.setString(4, student.getCountry());
//				Integer rowsAffected=pstmt.executeUpdate();
//				
//				if(rowsAffected==1) {
//					return status="s";
//				}else {
//					return status="f";
//				}
//			}
//			
//		} catch (SQLException | IOException e) {
//			e.printStackTrace();
//			status="f";
//		} 
		
		try {
			session=HibernateUtil.getsession();
			if(session!=null) {
				System.out.println("session obj is came");
				transaction= session.beginTransaction();
				
				if(transaction!=null) {
					Student student1= new Student();
					student1.setCity(student.getCity());
					student1.setCountry(student.getCountry());
					student1.setEmail(student.getEmail());
					student1.setName(student.getName());
					session.save(student1);
					flag=true;
				}else {
					System.out.println("transaction is null");
				}
			
			
		} 
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				status="s";
			}
			else {
				transaction.rollback();
				status="f";
			}
		}
		HibernateUtil.closeSession();
		return status;
	}

	@Override
	public Student findById(Integer sid) {
		Student student=null;
		Student student1=new Student();
//		String SqlSelectQuery="select sid,name,email,city,country from student where sid=?";
//		try {
//			connection= JdbcUtil.getConnnection();
//			
//			if(connection!=null) {
//				pstmt=connection.prepareStatement(SqlSelectQuery);
//				pstmt.setInt(1, sid);
//				ResultSet record=pstmt.executeQuery();
//				
//				if(record.next()) {
//					student=new Student();
//					student.setSid(record.getInt(1));
//					student.setName(record.getString(2));
//					student.setEmail(record.getString(3));
//					student.setCity(record.getString(4));
//					student.setCountry(record.getString(5));
//				}
//			}
//			
//		} catch (SQLException | IOException e) {
//			e.printStackTrace();
//			status="f";
//		} 
		try {
			session=HibernateUtil.getsession();
			if(session!=null) {
				System.out.println("session obj is came");
				student=session.load(Student.class, sid);
				if(student!=null) {
					System.out.println("student obj is not null");
					student1.setSid(student.getSid());
					student1.setCity(student.getCity());
					student1.setCountry(student.getCountry());
					student1.setEmail(student.getEmail());
					student1.setName(student.getName());
					flag=true;
				}
			}else {
				System.out.println("transaction is null");
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				
				status="s";
			}else {
				
				status="f";
			}
		}
		return student1;
	}

	@Override
	public String updateById(Student student) {
		
//		String SqlUpadateQuery="update student set name=?,email=?,city=?,country=? where sid=?";
//		try {
//			connection= JdbcUtil.getConnnection();
//			
//			if(connection!=null) {
//				pstmt=connection.prepareStatement(SqlUpadateQuery);
//				pstmt.setString(1, student.getName());
//				pstmt.setString(2, student.getEmail());
//				pstmt.setString(3, student.getCity());
//				pstmt.setString(4, student.getCountry());
//				pstmt.setInt(5, student.getSid());
//				Integer rowsAffected=pstmt.executeUpdate();
//				
//				if(rowsAffected==1) {
//					return status="s";
//				}else {
//					return status="f";
//				}
//			}
//			
//		} catch (SQLException | IOException e) {
//			e.printStackTrace();
//			status="f";
//		} 
		Boolean flag1=false;
		Student student1=null;
		Integer id=student.getSid();
		try {
			session=HibernateUtil.getsession();
			student1=session.get(Student.class, id);
			if(student1!=null) {
				transaction=session.beginTransaction();
				session.update(student);
				flag1=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(flag1) {
				transaction.commit();
				status="s";
			}else {
				transaction.rollback();
				status="f";
			}
		}
	
		
		return status;
	}

	@Override
	public String deleteById(Integer sid) {
//		String SqlDeleteQuery="delete from student where sid=?";
//		Student student=findById(sid);
//		
//		
//		if(student!=null) {
//			System.out.println("Student is present in DB....");
//		try {
//			connection= JdbcUtil.getConnnection();
//			
//			if(connection!=null) {
//				pstmt=connection.prepareStatement(SqlDeleteQuery);
//				pstmt.setInt(1, sid);
//				Integer rowsAffected=pstmt.executeUpdate();
//				
//				if(rowsAffected==1) {
//					return status="s";
//				}else{
//					return status="f";
//				}
//			}
//			
//		} catch (SQLException | IOException e) {
//			e.printStackTrace();
//			status="f";
//		} 
//	}else {
//		System.out.println("Student not present in DB...");
//		return status="Not Available";
//	}
		Boolean flag1=false;
		
		try {
			session=HibernateUtil.getsession();
			
			if(session!=null) {
			Student student=null;
			student=session.get(Student.class, sid);
			
			if(student!=null) {
				transaction=session.beginTransaction();
				System.out.println(student.getSid());
			if(transaction!=null) {
				session.delete(student);
				flag1=true;
			}	
			}else {
				flag1=false;
				System.out.println("Student is not found in data base with given Sid :: "+sid);
			}
		} 
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag1) {
				transaction.commit();
				status="s";
			}else {
				transaction.rollback();
				status="f";
			}
		}
		return status;
	}

}
