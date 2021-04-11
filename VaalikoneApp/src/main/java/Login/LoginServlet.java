package Login;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao_candidate;
import data.Candidate;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Dao_candidate dao=null;
	
	@Override
	public void init() {
		dao=new Dao_candidate("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
		System.out.println("");
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Candidate> list=null;
		//user input from loginPage.jsp
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		String sql = "SELECT * FROM electionmachine.candidates where USERNAME='" + user + 
				"' and PASSWORD='" + pwd + "';";
		String un = null;

		/*
		 * delete this shit later
		 */
		//userID = "'Aintila
		//password = "'puppyfarts'";
		

		
		if(dao.getConnection())
		{
			System.out.println("Successfully connected to Candidates to fetch login info");
			list=dao.loginCandidate(sql);
			
			//test
			System.out.println("Can_List: " + list);

			for (int i = 0; i < list.size(); i++) {
				Candidate c = list.get(i);
				
//				un = c.getUSERNAME().toString();
				un = String.valueOf(c.getId());

				System.out.println("Candidate id/name: " + c.getId() + " " + c.getUSERNAME());//
			}	
		}
		else
		{
			System.out.println("No connection to database");
		}
		

		//cookie -> send login ID
		if(list != null) {
			Cookie loginCookie = new Cookie("user", un);
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


