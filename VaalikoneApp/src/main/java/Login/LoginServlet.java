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

import data.Candidate;

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
		 * 
		 * -> String sql = "SELECT * FROM electionmachine.candidates WHERE username=" + userID + " AND password=" + password + ";";
		 * 
		 * -> if((sql==null) || (sql.equals("") || sql.length()==0) {
		 * authenticate = false;
		 * }
		 * else {
		 * }...cookie cont from here
		 * 
		 * instead of else-> else if (sql.length()==1)
		 * 
		 * other way if that doesn't work:
		 * leave if statement as is and just check that user and pwd in sql.
		 */
		
		//set this to sql data
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		Candidate orban = new Candidate();
		orban.setId(69);
		orban.setUSERNAME(user);
		orban.setPASSWORD(pwd);
		
		System.out.println(orban.getId() + orban.getUSERNAME() + orban.getPASSWORD());
		
		if(userID.equals(user) && password.equals(pwd)) {
			Cookie loginCookie = new Cookie("user", orban.getUSERNAME());
			Cookie phallos = new Cookie("id", String.valueOf(orban.getId()));
			response.addCookie(loginCookie);
			/*
			 * if login ok -> 
			 */
			response.sendRedirect("_TEST_LOGIN_SUCCESS.jsp");
		}else{
			/*
			 * if login not ok ->
			 */
			response.sendRedirect("loginPage.jsp");
		}

	}

}
