package wtp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis2.client.ServiceClient;

/**
 * Servlet implementation class clientservlet
 */
public class clientservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public clientservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	    
	public int tick(HttpServletRequest request,HttpServletResponse response,ServiceClient _serviceClient) throws ServletException, IOException{
				
		WelcomeStub stub=new WelcomeStub();
		WelcomeStub.Tickets tict=new WelcomeStub.Tickets();
		tict.setRequest(request);
		tict.setResponse(response);
		stub._setServiceClient(_serviceClient);
		try {
			stub.tickets(tict);
		} catch (IOExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

}
