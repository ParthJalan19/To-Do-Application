import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/")
public class TodoController extends HttpServlet
{
	private TodoDao todoDao;
	public void init()
	{
		todoDao = new TodoDao();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		try
		{
			String action = request.getServletPath();
			switch(action)
			{
				case "/new":
					showNewForm(request, response);
					break;
					
				case "/insert":
					insertRecord(request, response);
					break;
					
				case "/list":
					showList(request, response);
					break;
				
				default:
					RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
					dis.forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println("todocontroller switch : " + e);
		}
	}
	
	public void showNewForm(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		request.getRequestDispatcher("todo-form.jsp").forward(request, response);
	}
	
	public void insertRecord(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException,ClassNotFoundException
	{
		String username = request.getParameter("uname");
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		LocalDate target = LocalDate.parse(request.getParameter("target"));
		boolean status = Boolean.valueOf(request.getParameter("isDone"));
		Todo td = new Todo(id, title, target, status, username);
		todoDao.insertTodo(td);
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>your data inserted successfully!</h1>");
		out.println("<p><a href = '/todoapp/list?uname=" + username +"'>click here to see <p>");
		out.println("</body></html>");
	}
	
	public void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,ClassNotFoundException
	{
		String uname = request.getParameter("uname");
		/*PrintWriter out = response.getWriter();
		out.println("<h1>" + uname + "</h1>");*/
		List<Todo> listTodo = todoDao.selectAllTodos(uname);
		request.setAttribute("listTodo",listTodo);
		RequestDispatcher dis = request.getRequestDispatcher("todo-list.jsp");
		dis.forward(request,response);
	}
}