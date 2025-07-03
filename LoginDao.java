import java.sql.*;
public class LoginDao
{
	public boolean validate(Login lg)
	{
		boolean found = false;
		try
		{
			Connection con = JDBCutils.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from todouser where username = ? and password = ?");
			ps.setString(1,lg.getUsername());
			ps.setString(2,lg.getPassword());
			ResultSet rs = ps.executeQuery();
			found = rs.next();
		}
		catch(Exception e)
		{
			System.out.println("logindao : " + e.getMessage());
		}
		return found;
	}
}