package in.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.project.dao.LibrarianDAO;
import in.project.dao.LibrarianDAOImp;
import in.project.model.ValidateLibrarian;

@WebServlet("/Validate2")
public class Validate2 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	LibrarianDAO libdao =null;
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
	   ValidateLibrarian vl = new ValidateLibrarian();
	   vl.setLusername(username);
	   libdao = new LibrarianDAOImp();
	   String pass = libdao.librarianValidate1(vl);
	   System.out.println(pass+" inside validate 2");
	   HttpSession session = request.getSession();     
       session.setAttribute("pass", pass);
		if(pass==null)
		{
			 RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			 request.setAttribute("pass", pass);
			 System.out.println("inside null in validate 2");
		       rd.forward(request, response);
		} 
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("getpassword.jsp");
			session.setAttribute("pass", pass);
		    rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
//<div class="card-pass">forgot password ?</div>
	
	
	//<a href="login.jsp">click here to login page</a>
}
