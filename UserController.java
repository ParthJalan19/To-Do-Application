import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/register")
public class UserController extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		User user = new User();
		user.setFirstName(request.getParameter("fname"));
		user.setLastName(request.getParameter("lname"));
		user.setUsername(request.getParameter("uname"));
		user.setPassword(request.getParameter("pw"));
		try
		{
			int result = new UserDao().register(user);
			if(result > 0)
			{
				RequestDispatcher dis = request.getRequestDispatcher("Register.jsp");
				request.setAttribute("notification","user registered ");
				dis.forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println("usercontroller : " + e.getMessage());
		}
	}
}