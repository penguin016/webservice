package wtp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class hellp
 */
public class welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public welcome() {
    	 super();
    	 
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @return 
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public int tickets(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
    	
    	response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String docType =
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "+"Transitional//EN\">\n";
		out.println(docType+
		"<HTML>\n"+
		"<HEAD><TITLE>航空订票系统</TITLE></HEAD>\n"+
		"<BODY BGCOLOR=\"#FDF5E6\">\n"+
			"<H1 ALIGN=\"CENTER\">欢迎进入航空订票系统</H1>\n"+
			
			"<FORM ACTION=\"/ticket/book\" METHOD=\"GET\">"+
	"<CENTER> 出发地:<INPUT TYPE=\"TEXT\" NAME=\"departure\">" +
			"目的地:<INPUT TYPE=\"TEXT\" NAME=\"destination\">" +
					"起飞时间:<INPUT TYPE=\"TEXT\" NAME=\"origination\"><BR>" +
							"<BR>" +
							"<INPUT TYPE=\"SUBMIT\" VALUE=\"提交\">");
		return 0;
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		welcome get=new welcome();
		get.tickets(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
