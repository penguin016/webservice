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
 * Servlet implementation class book
 */
public class book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public book() {
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
				"<BODY BGCOLOR=\"#FDF5E6\">\n"+
				"<H1 ALIGN=CENTER>欢迎进入航空订票系统</H1>\n"+
				"<H2 ALIGN=CENTER>请选定您所需的航班</H2>\n"+
				"<FORM ACTION=\"/ticket/result\" METHOD=\"GET\">"+
				"<TABLE BORDER=1 ALIGN=CENTER>\n"+
				"<TR BGCOLOR=\"#FFAD00\">\n"+
				"<TH>出发地<TH>目的地<TH>起飞时间<TH>到达时间<TH>航班号<TH>航空公司<TH>价格<TH>剩余票数"			
				
				);
		String depa=new String(request.getParameter("departure").getBytes("ISO-8859-1"),"GB2312");
		String dest=new String(request.getParameter("destination").getBytes("ISO-8859-1"),"GB2312");
		String org=request.getParameter("origination");
		
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
		String query=null;
		
		
		if(depa!=null&&dest!=null&&org==null)
			query="select* from flight where departure='"+depa+"' and destination='"+dest+"'";
		/*if(depa==null&&dest==null&&org==null)
			query="select* from flight";*/
		if(org!=null){
			if(depa!=null&&dest!=null)
				query="select* from flight where departure='"+depa+"' and destination='"+dest+"' and origination like'"+org+"%'";
			else
				query="select* from flight where origination like'"+org+"%'";
		}
			
		ResultSet result = null;
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==null)
			out.println("你所差的航班不存在！");
		 try {
			while(result.next()){
			  out.println("<TR><TD>"+result.getString(1)+
					          "<TH>"+result.getString(2)+
					          "<TH>"+result.getString(3)+
					          "<TH>"+result.getString(4)+
					          "<TH>"+result.getString(5)+
					          "<TH>"+result.getString(6)+
					          "<TH>"+result.getInt(7)+
					          "<TH>"+result.getInt(8)+
					         "\n<TD>");
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<TR>\n"+
				"<CENTER> 航班号:<INPUT TYPE=\"TEXT\" NAME=\"fnumber\">" +
			"票数:<INPUT TYPE=\"TEXT\" NAME=\"num\"><BR>" +
							"<BR>" +
							"<CENTER><INPUT TYPE=\"SUBMIT\" VALUE=\"确认\">"+
							"</HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
