package in.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.project.model.Books;
import in.project.util.JDBCUtil;

public class BookDAOImp implements BookDAO{
	Connection con = null;
	
	
	public String save(Books book) {
		
		PreparedStatement ps = null;
		String status = null;
		String query="INSERT INTO `projectlibrary`.`books` (`bid`, `bname`, `bauther`, `bsubject`) VALUES (?,?,?,?)";
		try {
		con = JDBCUtil.physicalConnection();
		if(con!=null)
		{
			ps =con.prepareStatement(query);
			if(ps!=null)
			{
				ps.setInt(1, book.getBid());
				ps.setString(2, book.getBname());
				ps.setString(3, book.getBauthor());
				ps.setString(4, book.getBsubject());
					System.out.println(ps);
				int rowAffected = ps.executeUpdate();
				System.out.println(rowAffected);
				
				if (rowAffected == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			
			}
			con.close();
			ps.close();
			
		
		}
		}catch(Exception e) {
			System.out.println("in catch");
			status="failure";
		}
		return status;
		
		
	}

	public Books findById(int bid) {
		 PreparedStatement ps = null;
		  ResultSet rs = null;
		   Books book = null;
		  String bname = null;
		  String bsubject = null;
		  String bauthor = null;
		 
		  String query ="select bid,bname,bauther,bsubject from books where bid=?";
		  
		  try {
			  con =JDBCUtil.physicalConnection();
			  if(con!=null)
			  {
				  ps = con.prepareStatement(query);
				  if(ps!=null)
				  {
				    ps.setInt(1, bid);	  
				  }
				  if(ps!=null)
				  {
					  rs = ps.executeQuery();
				  }
				  rs.next();
				  if(rs!=null)
				  {
					  bname = rs.getNString("bname");
					  bsubject = rs.getNString("bsubject");
					  bauthor = rs.getNString("bauther");
					  
				  }
				  book = new Books();
				  book.setBauthor(bauthor);
				  book.setBid(bid);
				  book.setBname(bname);
				  book.setBsubject(bsubject);
				  
				  con.close();
				  ps.close();
				  rs.close();
			  }
		  }catch(Exception e) {}
			
			
			
			return book;
	}
	
	
	

	public String udateById(int bid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	public String deleteById(int bid) {
		 PreparedStatement ps = null;
		 String delBstatus = null;
		  String query ="delete from books where(bid=?)";
		  try {
			  con = JDBCUtil.physicalConnection();
			  if(con!=null)
			  {
				  ps = con.prepareStatement(query);
				  if(ps!=null)
				  {
					  ps.setInt(1, bid);
				  }
				  if(ps!=null)
				  {
					  int rowAffect = ps.executeUpdate();
					  if(rowAffect==1)
					  {
						  delBstatus="success";
					  }
					  else
					  {
						  delBstatus="failure";
					  }
				  }
			  }
			  
		  }catch(Exception e) {delBstatus="failure";}
		 
		 
		  
		return delBstatus;

	}

	public ResultSet findAll() {
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 String query ="Select* from books";
		  try {
			  con = JDBCUtil.physicalConnection();
			  if(con!=null)
			  {
				  ps = con.prepareStatement(query);
				  if(ps!=null)
				  {
					  rs = ps.executeQuery(query);
					  System.out.println(ps);
				  }
			  }
		  }catch(Exception e) {}
		return rs;
	}
}
