package Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
		
		// get request parameters for name and pass
		String n=request.getParameter("username");  
		String p=request.getParameter("userpass"); 
		
		
//		if(name.equals(n) && pass.equals(p)){
//			Cookie loginCookie = new Cookie("username",n);
//			//setting cookie to expiry in 30 mins
//			loginCookie.setMaxAge(30*60);
//			response.addCookie(loginCookie);
//			response.sendRedirect("index.jsp");
//		}else{
//			RequestDispatcher rd = getServletContext().getRequestDispatcher("index.jsp");
//			PrintWriter out= response.getWriter();
//			out.println("<font color=red>Either user name or password is wrong.</font>");
//			rd.include(request, response);
		
		
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