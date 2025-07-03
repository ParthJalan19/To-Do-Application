import java.sql.*;
public class UserDao
{
	public int register(User a) throws ClassNotFoundException
	{
		int result = 0;
		try
		{
		Connection con = JDBCutils.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into todouser values(?,?,?,?)");
		ps.setString(1,a.getUsername());
		ps.setString(2,a.getPassword());
		ps.setString(3,a.getFirstName());
		ps.setString(4,a.getLastName());
		
		result = ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("userdao : " + e.getMessage());
		}
		return result;
	}
}