

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginserv")
public class LoginServ extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("uname");
		String pass=request.getParameter("upass");
		
		if(pass.equals("123"))
		{
			//out.print("<a href='profile.html'>profile</a>"); 
			//response.sendRedirect("profile.html");
			//response.sendRedirect("https://www.asterisc.in");
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("profileserv");
			dispatcher.forward(request, response);
		}
		else
		{
			out.print("<p style='color:red'>Wrong password!</p>");

			request.getRequestDispatcher("index.html").include(request, response);
			out.print("<p style='color:red'>Wrong password!</p>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

}
