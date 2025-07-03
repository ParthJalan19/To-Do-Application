import java.sql.Date;
import java.time.LocalDate;
public class Todo
{
	public int id;
	public String title;
	public LocalDate target;
	public String username;
	public boolean status;
	Todo(int i,String title, LocalDate t, boolean b,String a)
	{
		id = i;
		this.title = title;
		target = t;
		status = b;
		username = a;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int i)
	{
		this.id = i;
	}
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String i)
	{
		this.username = i;
	}
	
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String t)
	{
		this.title =  t;
	}
	
	public void setTarget(LocalDate d)
	{
		this.target = d;
	}
	public LocalDate getTarget()
	{
		return target;
	}
	public boolean getStatus()
	{
		return status;
	}
	
	public void setStatus(boolean b )
	{
		this.status = b;
	}
}