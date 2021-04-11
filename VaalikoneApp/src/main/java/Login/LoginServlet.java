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
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Candidate> list = null;
		//user input from loginPage.jsp
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		String sql = "SELECT * FROM electionmachine.candidates where USERNAME='" + user + 
				"' and PASSWORD='" + pwd + "';";
		String send_id = null;

		
		if(dao.getConnection())
		{
			System.out.println("Successfully connected to Candidates to fetch login info");
			list = dao.loginCandidate(sql);
			
			System.out.println("Can_List: " + list);
			for (int i = 0; i < list.size(); i++) {
				Candidate c = list.get(i);
				//fetch id -> (String) send_id
				send_id = String.valueOf(c.getId());
				System.out.println("Candidate id/name: " + c.getId() + " " + c.getUSERNAME());
			}	
		}
		else
		{
			System.out.println("No connection to database");
		}
		
<<<<<<< Updated upstream
=======
		HttpSession session = request.getSession(false); //Creating a session
		if(session!=null)
			request.getSession(true).setAttribute("name", n);//setting session attribute
		if(LoginDatabaseConnection.validate(n, p)){  
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
			rd.forward(request,response);  

		}  
		else{  
			out.print("<p style=\"color:red\">Sorry username or password error</p>");  
			RequestDispatcher rd=request.getRequestDispatcher("loginPage.jsp");  
			rd.include(request,response);  
		}  

		out.close();  
	}
>>>>>>> Stashed changes

		//cookie -> send login ID
		if(send_id != null) {
			Cookie id_cookie = new Cookie("user", send_id);
			response.addCookie(id_cookie);			
			/*
			 * if login ok -> 
			 */
			response.sendRedirect("_TEST_LOGIN_SUCCESS.jsp");
		}else{
			/*
			 * if login not ok ->
			 * must add error message!
			 */
			response.getWriter().println("<p style=\"color:red\">Sorry username or password error</p>");
			RequestDispatcher rd = request.getRequestDispatcher("loginPage.jsp");
			rd.include(request,response);
		}
	}
		
}


