package in.project.factory;

import in.project.service.IStudentService;
import in.project.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static IStudentService studentService=null;
	private StudentServiceFactory() {
		
	}
	public static IStudentService getStudentService() {
		if(studentService==null) {
			studentService=new StudentServiceImpl();
		}
		
		return studentService;
	}
}
