import java.sql.Date;
import java.time.LocalDate;
import java.sql.*;

public class JDBCutils 
{
	public static String url = "jdbc:mysql://localhost:3306/todolist";
	public static String user = "root";
	public static String pass = "123";
	
	public static Connection getConnection()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pass);
		}
		catch(Exception e)
		{
			System.out.println("error jdbcutils : " + e.getMessage());
		}
		return con;
	}
	
	public static LocalDate getUtilDate(Date sqldate)
	{
		return sqldate.toLocalDate();
	}
	public static Date getSQLDate(LocalDate date)
	{
		return Date.valueOf(date);
	}
}