package wtp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class result
 */
public class result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public result() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String docType =
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "+"Transitional//EN\">\n";
		
		out.println(docType+
				"<HTML>\n"+
				"<HEAD><TITLE>航空订票系统</TITLE></HEAD>\n"+
				"<BODY BGCOLOR=\"#FDF5E6\">\n"
				);
		String fl=request.getParameter("fnumber");
		String nu=request.getParameter("num");
		int one=Integer.parseInt(nu);
		int all = 0;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/my";
		String user="root";
		String password="000000";
	    Connection connection=null;
	    try {
			connection= DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Statement statement =null;
		try {
			statement=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query="select* from flight where fnumber='"+fl+"'";
		ResultSet result = null;
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int eight = 0;
		int seven = 0;
		try {
			while(result.next()){
				eight=result.getInt(8);
			    seven=result.getInt(7);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(one>eight)
			out.println("<H1 ALIGN=CENTER>对不起！系统中没有这么多票数，请重新选定。</H1>\n");
		else{
			all=one*seven;
		try {
			String update="update flight set remaining='"+(eight-one)+"' where fnumber='"+fl+"'";
			statement.executeUpdate(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<H1 ALIGN=CENTER>订票成功！本次订票你总共花费"+all+"元"+"</H1>\n");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
