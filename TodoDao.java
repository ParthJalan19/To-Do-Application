import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
public class TodoDao
{
	public int insertTodo(Todo d) throws ClassNotFoundException
	{
		int result = 0;
		try
		{
		Connection con = JDBCutils.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into todos values(?,?,?,?,?)");
		ps.setInt(1, d.getId());
		ps.setString(2,d.getTitle());
		ps.setDate(3,JDBCutils.getSQLDate(d.getTarget()));
		ps.setBoolean(4,Boolean.valueOf(d.getStatus()));
		ps.setString(5, d.getUsername());
		result = ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("tododao inserttodo error : " + e.getMessage());
		}
		return result;
	}
	public List<Todo> selectAllTodos(String u) throws ClassNotFoundException
	{
		List<Todo> todos = new ArrayList<>();
		try
		{
		
		Connection con = JDBCutils.getConnection();
		PreparedStatement ps = con.prepareStatement("select id, title, target_date, is_done,username from todos where username = ?");
		ps.setString(1, u);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			int i = rs.getInt(1);
			String title = rs.getString(2);
			LocalDate d = JDBCutils.getUtilDate(rs.getDate(3));
			boolean b = Boolean.valueOf(rs.getString(4));
			String un = rs.getString(5);
			todos.add(new Todo(i,title,d,b,un));
		}
		}
		catch(Exception e)
		{
			System.out.println("tododao selectalltodos error : " + e.getMessage());
			e.printStackTrace();
		}
		return todos;
	}
}