package in.project.factory;

import in.project.dto.IStudentDto;

import in.project.dto.StudentDtoImpl2;

public class StudentDtoFactory {
	private static  IStudentDto studentDto= null;
	
	public StudentDtoFactory() {
		
	}
	public static IStudentDto getStudentDto() {
		if(studentDto==null) {
			studentDto=new StudentDtoImpl2();
		}
		return studentDto;
		
	}

}
