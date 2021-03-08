package hotel.Controller;

import javax.servlet.http.*;

import hotel.Login;
import hotel.Constants.GlobalConstants;
import hotel.DAO.UserService;

public class BaseController extends HttpServlet {
	private static final long serialVersionUID = 4481510681863866579L;
	private UserService userServices = new UserService();	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			String action = request.getParameter("action");
			doPostAction(action, request, response);
		} catch (Exception e) {
			System.out.println("Error in Input Output " + e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			String action = request.getParameter("action");
			doGetAction(action, request, response);
		} catch (Exception e) {
			System.out.println("Error in Input Output " + e);
		}
	}
	
	public void doPostAction(String action, HttpServletRequest request,
			HttpServletResponse response) {		
		try {
			action = action.toLowerCase();
			if (action.equals("login")) {
				Login Login = new Login();
				Login.setUserName(request.getParameter("userName"));
				Login.setPassword(request.getParameter("password"));

				if (userServices.checkLogin(Login)) {					
					HttpSession session = request.getSession();
					System.out.println(Login);
					session.setAttribute(GlobalConstants.USER, Login);
					GlobalConstants.JSP_PAGE = "UserHome.jsp";
				} else {
					GlobalConstants.MESSAGE = GlobalConstants.ERROR_INVALID_CREDS;
					GlobalConstants.JSP_PAGE = "LoginPage.jsp";
				}
				response.sendRedirect(GlobalConstants.JSP_PAGE);
			}
		} catch (Exception e) {
			System.out.println("Error in doPostAction() " + e);
			e.printStackTrace();
		}
	}

	public void doGetAction(String action, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			System.out.println("action in doGet " + action);
		} catch (Exception e) {
			System.out.println("Error in doGetAction - " + e);
		}

	}
}