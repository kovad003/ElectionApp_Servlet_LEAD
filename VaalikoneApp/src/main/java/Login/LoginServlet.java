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
		String pwd = Encryption.crypt(request.getParameter("pwd"));
		String sql = "SELECT * FROM electionmachine.candidates where USERNAME='" + user + 
				"' and PASSWORD='" + pwd + "';";
		String id_push = null;

		
		if(dao.getConnection())
		{
			System.out.println("Successfully connected to Candidates to fetch login info");
			/*
			 * creates candidate arraylist with attributres appended
			 */
			list = dao.loginCandidate(sql);
			System.out.println("Can_List: " + list);
			for (int i = 0; i < list.size(); i++) {
				Candidate c = list.get(i);
				/*
				 * (String) CANDIDATE_ID -> id_push
				 */
				id_push = String.valueOf(c.getId());
				System.out.println("Candidate id/name: " + c.getId() + " " + c.getUSERNAME());//
			}	
		}
		else
		{
			System.out.println("No connection to database");
		}
		

		/*
		 * If username and password from loginPage.jsp exist on the same row in candidates
		 * table -> id_push is set to that candidate's CANDIDATE_ID -> therefore login exists
		 * and can proceed to initialize cookie
		 * else id_push will be null -> login will not proceed
		 */
		if(id_push != null) {
			Cookie id_cookie = new Cookie("user", id_push);
			response.addCookie(id_cookie);			
			/*
			 * if login ok -> 
			 */
			
			response.sendRedirect("_TEST_LOGIN_SUCCESS.jsp");
		}else{
			/*
			 * if login not ok ->
			 */
			response.getWriter().println("<div class = \"logoutFail\"><i>Sorry, username or password error. Please try again.</i></div>");
			RequestDispatcher rd = request.getRequestDispatcher("loginPage.jsp");
			rd.include(request,response);
			
		}
	}
		
}

