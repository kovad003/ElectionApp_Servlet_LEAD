package Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class: LogoutServlet
 * The servlet class houses the post HTTP response that logs users out
 * upon request. Method description found in method notes.
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	
	/**
	 * Identifier that ensures same version used for serialization and
	 * deserialization by JVM.
	 */
	private static final long serialVersionUID = 1L;
       
	
    /**
     * HTTP Post response logs user out upon request if user logged in. Method implemented
     * using cookie based session. Redirects to "loginPage.jsp" upon completion.
     * @throws ServletException | IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	Cookie loginCookie = null;
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null){
	    	for(Cookie cookie : cookies){
	    		if(cookie.getName().equals("user")){
	
	    			loginCookie = cookie;
	    			break;
	    		}
	    	}
    	}
    	if(loginCookie != null){
    		loginCookie.setMaxAge(0);
        	response.addCookie(loginCookie);
    	}
    	
    	/*
    	 * go here after logout ->
    	 */    	
    	response.sendRedirect("loginPage.jsp");
    }

}
