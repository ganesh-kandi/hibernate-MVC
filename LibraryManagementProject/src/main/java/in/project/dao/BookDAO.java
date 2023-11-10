package in.project.dao;

import java.sql.ResultSet;

import in.project.model.Books;

public interface BookDAO {
	String save(Books book);
    Books findById(int bid);
    String udateById(int bid);
    String deleteById(int bid);
    ResultSet findAll();
}
