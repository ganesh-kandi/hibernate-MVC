package in.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.project.dao.BookDAO;
import in.project.dao.BookDAOImp;
import in.project.dao.IssueBookDAO;
import in.project.dao.IssueBookImp;
import in.project.dao.StudentDAO;
import in.project.dao.StudentDAOImp;
import in.project.model.Books;
import in.project.model.Student;

@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int sid = Integer.parseInt(request.getParameter("sid"));
    int bid =  Integer.parseInt(request.getParameter("bid"));
    String issuedate = request.getParameter("issuedate");
    String duedate = request.getParameter("duedate");
    String issuestatus = "error";
    IssueBookDAO isbook = new IssueBookImp();
    BookDAO bk = new BookDAOImp();
    StudentDAO student =  new StudentDAOImp();
    Student std = null;
    Books book = null;
    
    book = bk.findById(bid);
    std = student.findById(sid);
    
    if(book!=null && std!=null)
    {
    	issuestatus = isbook.issuebook(sid, bid, issuedate, duedate);
    }

	
			HttpSession session = request.getSession();
			session.setAttribute("issuestatus", issuestatus);
			response.sendRedirect("issuebook.jsp");
		

}
}
