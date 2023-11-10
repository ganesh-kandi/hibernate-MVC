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
import in.project.model.Books;

@WebServlet("/DelBook")
public class DeleteBook extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int bid = Integer.parseInt(request.getParameter("book-id"));
	String delBstatus = null;
	BookDAO bookdao = new BookDAOImp();
	Books book = new Books();
	
    book = bookdao.findById(bid);
    if(book!=null)
    {
    	delBstatus = bookdao.deleteById(bid);
    }
    HttpSession session = request.getSession();     
    session.setAttribute("delBstatus",delBstatus);
    response.sendRedirect("delbook.jsp");
	}
}
