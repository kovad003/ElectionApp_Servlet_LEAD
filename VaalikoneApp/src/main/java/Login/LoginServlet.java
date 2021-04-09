package Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private final String userID = "admin";
	private final String password = "admin";

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * TODO:
		 * -> setup user/pass in db
		 * -> boolean authenticate = false;
		 * -> String user/pwd = read in those 2 fields
		 * -> String sql = "SELECT * FROM table WHERE username=" + user + " AND password=" + pwd + ";";
		 * -> if((sql==null) || (sql.equals("") || sql.length()==0) {
		 * authenticate = false;
		 * }
		 * else {
		 * }...cookie cont from here
		 * 
		 * other way if that doesn't work:
		 * leave if statement as is and just check that user and pwd in sql.
		 */
		
		//set this to sql data
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		
		
		if(userID.equals(user) && password.equals(pwd)) {
			Cookie loginCookie = new Cookie("user",user);
			response.addCookie(loginCookie);
			/*
			 * login ok -> 
			 */
			response.sendRedirect("_TEST_LOGIN_SUCCESS.jsp");
		}else{
			/*
			 * login not ok ->
			 */
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginPage.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>You are a poopiehead</font>");
			rd.include(request, response);
		}

	}

}
