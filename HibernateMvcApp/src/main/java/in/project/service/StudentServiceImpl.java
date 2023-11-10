package in.project.service;

import in.project.Model.Student;
import in.project.dto.IStudentDto;
import in.project.factory.StudentDtoFactory;

public class StudentServiceImpl implements IStudentService {

	
	IStudentDto studentDto;
	@Override
	public String save(Student student) {
		studentDto=StudentDtoFactory.getStudentDto();
		return studentDto.save(student);
	}

	@Override
	public Student findById(Integer sid) {
		studentDto=StudentDtoFactory.getStudentDto();
		return studentDto.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		studentDto=StudentDtoFactory.getStudentDto();
		return studentDto.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) {
		studentDto=StudentDtoFactory.getStudentDto();
		return studentDto.deleteById(sid);
	}
}
