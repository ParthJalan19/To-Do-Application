import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginController extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		Login lg = new Login();
		String uname =request.getParameter("uname");
		lg.setUsername(uname);
		lg.setPassword(request.getParameter("password"));
		if(new LoginDao().validate(lg))
		{
			request.getRequestDispatcher("/list").forward(request,response);
		}
		else
		{
			out.println("<h1>you are not registered user </h1>");
			out.println("<p><a href='" + request.getContextPath()+ "/Register.jsp'>kindly register here</a></p>");
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
}