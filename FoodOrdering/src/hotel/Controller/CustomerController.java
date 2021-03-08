package hotel.Controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
private static final long serialVersionUID = -2019821864628575150L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		String action = request.getParameter("action");
		doPostAction(action, request, response);
	}
	private void doPostAction(String action, HttpServletRequest request,
			HttpServletResponse response) {
		
		
	}

}
