package in.project.service;

import in.project.Model.Student;

public interface IStudentService {
	String save(Student student);
	Student findById(Integer sid);
	String deleteById(Integer sid);
	String updateById(Student student);
}
