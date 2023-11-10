package in.project.dto;

import in.project.Model.Student;

public interface IStudentDto {
	String save(Student student);// Creating a record
	Student findById(Integer sid);// Reading a record
	String updateById(Student student);// Updating a record
	String deleteById(Integer sid);// Deleting a record
}
