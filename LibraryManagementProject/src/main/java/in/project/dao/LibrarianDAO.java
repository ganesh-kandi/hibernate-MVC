package in.project.dao;

import in.project.model.Librarian;
import in.project.model.ValidateLibrarian;

public interface LibrarianDAO {
	String save(Librarian librarian);
	int librarianValidate(ValidateLibrarian validateLib);
	public String librarianValidate1(ValidateLibrarian validateLib);
	String deleteById(int lid);
	String findById(int lid);
}
