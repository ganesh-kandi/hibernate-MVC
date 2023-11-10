package in.project.dao;

import java.sql.ResultSet;

import in.project.model.Student;

public interface StudentDAO {
	String save(Student student);
    Student findById(int sid);
    String udateById(int sid);
    String deleteById(int sid);
    ResultSet findAll();
}
