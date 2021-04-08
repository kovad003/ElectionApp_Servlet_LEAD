package Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.LoginDatabaseConnection;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		
		String n=request.getParameter("username");  
		String p=request.getParameter("userpass"); 
		
		HttpSession session = request.getSession(false); //Creating a session
		if(session!=null)
			request.getSession(true).setAttribute("name", n);//setting session attribute
		if(LoginDatabaseConnection.validate(n, p)){  
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
			rd.forward(request,response);  

		}  
		else{  
			out.print("<p style=\"color:red\">Sorry email or password error</p>");  
			RequestDispatcher rd=request.getRequestDispatcher("loginPage.jsp");  
			rd.include(request,response);  
		}  

		out.close();  
	}  
}  